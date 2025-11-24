package com.example.OTPdemo;

import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtPdemoApplication {

	private final static String Account_SID="";
	private final static String Auth_ID="";

	static {
		Twilio.init(Account_SID,Auth_ID);
	}
	public static void main(String[] args) {

		SpringApplication.run(OtPdemoApplication.class, args);

	}



}
