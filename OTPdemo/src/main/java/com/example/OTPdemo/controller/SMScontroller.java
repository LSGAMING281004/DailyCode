package com.example.OTPdemo.controller;

import com.example.OTPdemo.entity.TwilioRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;


@RestController
public class SMScontroller {

    String msg;
    @GetMapping
    public String test()
    {
        return "LOKESH LTS PVT company OTP is:"+generateOTP(6);
    }

    @PostMapping("/otp")
    public String checkOTP(@RequestBody TwilioRequest twilioRequest)
    {
        if(twilioRequest.checkOTP.equals(msg))
        {
            return "Your OTP is correct!";
        }else{
            return "Invalid OTP";
        }
    }

    @PostMapping("/sms")
    public ResponseEntity<String> sendMessage(@RequestBody TwilioRequest twilioRequest)
    {
        if(twilioRequest.getToPhoneNumber()==null)
        {
            return ResponseEntity.badRequest().body("Invalid request");
        }

        String fromNumber = "+12133761910";
        msg = generateOTP(6);
        String toNumber = twilioRequest.getToPhoneNumber();

        Message.creator(new PhoneNumber(toNumber),new PhoneNumber(fromNumber),msg).create();
        return  ResponseEntity.ok("OTP send Success");
    }

    private static final SecureRandom random = new SecureRandom();

    public static String generateOTP(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // generates a digit between 0-9
        }
        return otp.toString();
    }
}
