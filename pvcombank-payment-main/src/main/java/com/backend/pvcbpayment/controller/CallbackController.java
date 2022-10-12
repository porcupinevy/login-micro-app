package com.backend.pvcbpayment.controller;


import com.backend.pvcbpayment.PVCBPaymentConfig;
import com.backend.pvcbpayment.common.PemUtils;
import com.backend.pvcbpayment.entity.TransferCallbackEntity;
import com.backend.pvcbpayment.repository.TransferCallbackEntityReponsitory;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAKey;
import java.util.Base64;

@RestController
@RequestMapping("/callback/pvcb/")
public class CallbackController {

    private RSAKey rsaKey;

    private PemUtils pemUtils;
    private PublicKey publicKey;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PVCBPaymentConfig pvcbPaymentConfig;
    @Autowired
    TransferCallbackEntityReponsitory transferCallbackEntityReponsitory;

    public CallbackController() throws IOException {
        rsaKey = (RSAKey) pemUtils.readPublicKeyFromFile("pem/publicCallBackUAT.pem","RSA");
     //   String rsaKey1 = rsaKey.toString("base64");
    }
    @PostConstruct
    private void init() throws IOException {
        publicKey = pemUtils.readPublicKeyFromFile("pem/publicCallBackUAT.pem","RSA");
    }


    @PostMapping(value = "{token}/epg/transfer")
    private ResponseEntity<String>  createCallbackUrl(@PathVariable("token") String token, @RequestBody String body)
            throws IOException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        LOGGER.info("start createCallbackUrl");
        if(!token.equals(pvcbPaymentConfig.token)){
            LOGGER.error("sai link");
            return new ResponseEntity<>("Fail ", HttpStatus.BAD_REQUEST);
        }

        JSONObject bodyJSON = new JSONObject(body);
        if(null == bodyJSON){
            LOGGER.error("createCallbackUrl body null");
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST) ;
        }
        if(null == bodyJSON.getJSONObject("data") || null == bodyJSON.getString("signature") ){
            LOGGER.error("createCallbackUrl body data or signature null");
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST) ;
        }
        LOGGER.info("createCallbackUrl check signature");
        if(!checkSignature(bodyJSON.getJSONObject("data"), bodyJSON.getString("signature"))){
            LOGGER.error("createCallbackUrl check signature fail");
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST) ;
        }
        TransferCallbackEntity transferCallbackEntity = (TransferCallbackEntity) bodyJSON.get("data");
        LOGGER.info("createCallbackUrl save data");
        transferCallbackEntityReponsitory.save(transferCallbackEntity);
        return new ResponseEntity<>("ok", HttpStatus.OK) ;
    }

    private boolean checkSignature(JSONObject data, String signature1 ){
        try {
            LOGGER.info("createCallbackUrl start checkSignature");
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            byte[] messageBytes = data.toString().getBytes();
            signature.update(messageBytes);
            byte[] decodedBytes = Base64.getDecoder().decode(signature1);
//            String decodedString = new String(decodedBytes);
//            System.out.println("áaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//            System.out.println(decodedString);
//            System.out.println("áaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            LOGGER.info("createCallbackUrl end checkSignature");
            return signature.verify(decodedBytes);
        } catch (Exception e) {
            LOGGER.error("checkSignature error: "+e);
        }
        return false;
    }
}
