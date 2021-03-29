package com.example.twilio_sms_sender.service;

import com.example.twilio_sms_sender.entity.SmsRequest;
import com.example.twilio_sms_sender.support.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    private final TwilioSmsSender smsSender;

    public TwilioService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest request) {
        smsSender.send(request);
    }
}
