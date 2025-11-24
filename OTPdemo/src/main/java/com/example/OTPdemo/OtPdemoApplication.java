package com.example.OTPdemo;

import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtPdemoApplication {

	private final static String Account_SID="AC5f5b8c65b4fcffc982d2fe54c489817e";
	private final static String Auth_ID="56de4ccb735118ad6e4e8fe1cbce8894";

	static {
		Twilio.init(Account_SID,Auth_ID);
	}
	public static void main(String[] args) {

		SpringApplication.run(OtPdemoApplication.class, args);

	}



}
