package com.example.twilio_sms_sender.config;

import com.twilio.Twilio;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
@Slf4j
public class TwilioInitializer {

    private final TwilioConfig twilioConfig;

    @PostConstruct
    public void init() {
        String sid = twilioConfig.getSid();
        String token = twilioConfig.getToken();
        Twilio.init(sid, token);
        log.info("Twilio init with sid {} and token {}", sid, token);
    }
}
