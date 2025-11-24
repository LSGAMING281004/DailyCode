package com.example.OTPdemo.entity;

import lombok.Data;

@Data
public class TwilioRequest {

    public final String toPhoneNumber;
    public final String message;
    public final String checkOTP;
}
