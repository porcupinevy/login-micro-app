package com.backend.pvcbpayment.common;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.*;

public class SignatureUtils {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private PublicKey publicKey;

    public SignatureUtils() {

    }

    private boolean checkSignature(JSONObject data, String signature1 ) throws IOException, InvalidKeyException, NoSuchAlgorithmException, SignatureException {
        LOGGER.info("createCallbackUrl start checkSignature");
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        byte[] messageBytes = data.toString().getBytes();
        signature.update(messageBytes);
        LOGGER.info("createCallbackUrl end checkSignature");
        return signature.verify(signature1.getBytes());
    }

    public String getSignature(String data) throws IOException, InvalidKeyException, NoSuchAlgorithmException, SignatureException  {
        publicKey = PemUtils.readPublicKeyFromFile("pem/publicCallBackUAT.pem","RSA");
        LOGGER.info("createCallbackUrl start checkSignature=> "+data);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        byte[] messageBytes = data.getBytes();
        signature.update(messageBytes);
        LOGGER.info("signature: => "+Base64.encodeBase64(signature.toString().getBytes()));
        return Base64.encodeBase64String(signature.toString().getBytes()).toString();

    }

}
