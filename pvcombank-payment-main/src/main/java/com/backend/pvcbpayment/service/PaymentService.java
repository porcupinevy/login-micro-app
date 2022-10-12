package com.backend.pvcbpayment.service;

import com.backend.pvcbpayment.PVCBPaymentConfig;
import com.backend.pvcbpayment.model.Bank;
import com.backend.pvcbpayment.model.FundTransferRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;


@Service
public class PaymentService {


    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PVCBPaymentConfig pvcbPaymentConfig;

    private static String OAUTH_URL;
    private static String BASE_URL;

    @PostConstruct
    public void pvcomConfig() {
        this.OAUTH_URL = pvcbPaymentConfig.authURL;
        this.BASE_URL =  pvcbPaymentConfig.baseURL;
    }

    public String generateToken(String tokenType) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body;
        if (StringUtils.equals(tokenType,"CARD")) {
            body =  new FormBody.Builder()
                    .add("grant_type",pvcbPaymentConfig.grantType)
                    .add("client_id",pvcbPaymentConfig.cardClientId)
                    .add("client_secret", pvcbPaymentConfig.cardClientSecret)
                    .build();
        } else {
            body =  new FormBody.Builder()
                    .add("grant_type",pvcbPaymentConfig.grantType)
                    .add("client_id",pvcbPaymentConfig.clientId)
                    .add("client_secret", pvcbPaymentConfig.clientSecret)
                    .build();
        }
        Request request = new Request.Builder()
                .url(OAUTH_URL)
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            if (jsonObject.has("access_token")) {
                return jsonObject.getString("access_token");
            }
        }
        return null;
    }

    // Lấy danh sách ngân hàng
    public String getBank(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL+"/payment/v1/bank")
                .method("GET",null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+accessToken)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful()) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            JSONObject jsonObject = new JSONObject(response.body().string());
//            if (jsonObject.has("banks"))
//            List<Bank> banks = objectMapper.readValue(jsonObject.getJSONArray("banks").,Bank.class)
            return response.body().string();
        }
        return null;
    }

    // Hàm Chi Hộ
    public String funcTransfer(String accessToken, FundTransferRequest fundTransferRequest) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body =  new FormBody.Builder()
                .add("paymentId",fundTransferRequest.getPaymentId())
                .add("ftType",fundTransferRequest.getFtType().name())
                .add("numberOfBeneficiary", fundTransferRequest.getNumberOfBeneficial())
                .add("amount", String.valueOf(fundTransferRequest.getAmount()))
                .add("description",fundTransferRequest.getDescription())
                .add("bankId",fundTransferRequest.getBankId())
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL+"/v1/fundtransfer/tranferbank")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-idempotency-key", generateIdempotency())
                .addHeader("Authorization", "Bearer "+accessToken)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    // Truy vấn thông tin TK
    public String inquiryAccount(String accessToken,FundTransferRequest fundTransferRequest) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body =  new FormBody.Builder()
                .add("paymentId",fundTransferRequest.getPaymentId())
                .add("ftType",fundTransferRequest.getFtType().name())
                .add("numberOfBeneficiary", fundTransferRequest.getNumberOfBeneficial())
                .add("amount", String.valueOf(fundTransferRequest.getAmount()))
                .add("description",fundTransferRequest.getDescription())
                .add("bankId",fundTransferRequest.getBankId())
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL+"/payment/v1/fundtransfer/tranferbank")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+accessToken)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    // Lấy thông tin TK
    public String getAccountDetail(String accessToken, String accountNumber) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL+"/v1/account/getaccountdetail/"+accountNumber)
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-idempotency-key", generateIdempotency())
                .addHeader("Authorization", "Bearer "+accessToken)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    // Tạo thẻ nội địa
    public String createDebitCorp(String accessToken, String accountNumber) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL+"/card/v1/debit-corp")
                .method("POST", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+accessToken)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return null;
    }

    //ham push notification

    //ham get thong tin tai khoan theo cu phap

    //ham map so the vs user_id nguoi dung

    //ham sinh noi dung chuyen tien + so tai khoan

    //ham get lich su rut tien/nap tien (chon tu ngay den ngay toi da 3 thang)

    private String generateIdempotency() {
        final String random = String.valueOf(Math.floor((Math.random()*100000 +1)));
        return random;
    }

}


