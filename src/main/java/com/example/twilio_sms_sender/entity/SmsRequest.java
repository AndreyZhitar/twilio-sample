package com.example.twilio_sms_sender.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SmsRequest {

    private final String phoneNumber;
    private final String message;

}
