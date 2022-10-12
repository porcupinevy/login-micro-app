package com.backend.pvcbpayment.controller;

import com.backend.pvcbpayment.model.APIResponse;
import com.backend.pvcbpayment.model.FundTransferRequest;
import com.backend.pvcbpayment.service.PaymentService;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pv-payment")
public class PaymentController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentService paymentService;

    private String ACCESS_TOKEN;

    public PaymentController() {

    }

    @PostMapping(value = "/payment")
    public ResponseEntity<APIResponse> generateToken() {
        try {
            String responseData = paymentService.generateToken("PAYMENT");
            ACCESS_TOKEN = responseData;
            APIResponse response = new APIResponse(200,"Success",responseData);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/card")
    public ResponseEntity<APIResponse> generateCardToken() {
        try {
            String responseData = paymentService.generateToken("CARD");
            ACCESS_TOKEN = responseData;
            APIResponse response = new APIResponse(200,"Success",responseData);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("ex get-bank: "+ex);
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/get-bank")
    public ResponseEntity<APIResponse> getBankId() {
        try {
            LOGGER.info("kiem tra access_token"+ACCESS_TOKEN);
            String responseData = paymentService.getBank(ACCESS_TOKEN);
            APIResponse response = new APIResponse(200,"Success",responseData);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("ex get-bank: "+ex);
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/payment/fundTransfer")
    @ResponseBody
    public ResponseEntity<APIResponse> fundTransferAPI(@RequestParam FundTransferRequest transferRequest) {
        try {
            LOGGER.info("kiem tra access_token"+ACCESS_TOKEN);
            String responseData = paymentService.funcTransfer(ACCESS_TOKEN,transferRequest);
            APIResponse response = new APIResponse(200,"Success",responseData);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("ex fundTransferAPI"+ex);
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PostMapping(value = "/payment/fundTransfer/inquiry")
    @ResponseBody
    public ResponseEntity<APIResponse> inquiryAccountAPI(@RequestParam FundTransferRequest transferRequest) {
        try {
            LOGGER.info("check access_token"+ACCESS_TOKEN);
            String responseData = paymentService.inquiryAccount(ACCESS_TOKEN,transferRequest);
            APIResponse response = new APIResponse(200,"Success",responseData);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("ex inquiryAccountAPI : "+ex);
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
