package com.example.twilio_sms_sender.support;

import com.example.twilio_sms_sender.entity.SmsRequest;

public interface SmsSender {

    void send(SmsRequest request);
}
