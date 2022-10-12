package com.backend.pvcbpayment;

import com.backend.pvcbpayment.common.PemUtils;
import com.backend.pvcbpayment.common.SignatureUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.interfaces.RSAKey;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PVCBPaymentApplicationTests {


	@Test
	public void testPemUtils_willReturnPublicKeyString() throws IOException {
		RSAKey pubRSA = (RSAKey) PemUtils.readPublicKeyFromFile("pem/publicCallBackUAT.pem", "RSA");
		System.out.print("Public Key: "+pubRSA.getModulus());
	}


//	@Test
//	public void testPemUtils_willReturnPrivateKeyString() throws IOException {
//		RSAKey privateKey = (RSAKey) PemUtils.readPrivateKeyFromFile("pem/publicCallBackUAT.pem", "RSA");
//		System.out.print("Private Key: "+privateKey.toString());
//	}


	@Test
	public void testSignature()  {
		try {
			String test = new SignatureUtils().getSignature("{\n" +
					"    \"id\":444,\n" +
					"    \"ft_type\": \"AAC\",\n" +
					"    \"amount\": 300000000,\n" +
					"    \"balance\": 300000,\n" +
					"    \"sender_bankId\": \"234\",\n" +
					"    \"description\": \"CHUYEN TIEN VNFITE\",\n" +
					"    \"transId\": \"312312\",\n" +
					"    \"dateTime\": \"2022-09-13 23:00:00\",\n" +
					"    \"tranStatus\": \"Y\",\n" +
					"    \"conAmount\": \"312313213\",\n" +
					"    \"numberOfBeneficiary\": \"321321\",\n" +
					"    \"account\": \"10884378\"\n" +
					"}");
			System.out.print("sinature: "+test);
		} catch (Exception ex) {

		}

	}

	@Test
	void contextLoads() {
	}

}
