package com.backend.pvcbpayment;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class PVCBPaymentConfig {

    @Value("${spring.config.auth_url}")
    public String authURL;

    @Value("${spring.config.base_url}")
    public String baseURL;

    @Value("${spring.config.grant_type}")
    public String grantType;
    @Value("${spring.config.payment.client_id}")
    public String clientId;
    @Value("${spring.config.payment.client_secret}")
    public String clientSecret;

    @Value("${spring.config.card.client_id}")
    public String cardClientId;
    @Value("${spring.config.card.client_secret}")
    public String cardClientSecret;

    @Value("${pvcom.token}")
    public String token;

}
