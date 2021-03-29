package com.example.twilio_sms_sender.controller;

import com.example.twilio_sms_sender.entity.SmsRequest;
import com.example.twilio_sms_sender.service.TwilioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("send")
@AllArgsConstructor
public class SenderController {

    private final TwilioService service;

    @PostMapping
    public void sendSms(@RequestBody SmsRequest request) {
        service.sendSms(request);
    }
}
