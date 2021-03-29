package com.example.twilio_sms_sender.support;

import com.example.twilio_sms_sender.config.TwilioConfig;
import com.example.twilio_sms_sender.entity.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("twilio")
@AllArgsConstructor
@Slf4j
public class TwilioSmsSender implements SmsSender {

    private final TwilioConfig twilioConfig;

    @Override
    public void send(SmsRequest request) {

        MessageCreator creator = null;
        String phoneNumber = request.getPhoneNumber();
        if (isPhoneNumberValid(phoneNumber)) {
            PhoneNumber to = new PhoneNumber(phoneNumber);
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber());
            String message = request.getMessage();
            creator = Message.creator(to, from, message);
            creator.create();
            log.info("Send sms {}", request);
        } else {
            throw new IllegalArgumentException("Phone number " + phoneNumber + " is not valid!");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //TODO implement google library to check valid number
        return true;
    }
}
