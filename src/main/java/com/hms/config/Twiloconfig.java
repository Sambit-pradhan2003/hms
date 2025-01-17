package com.hms.config;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;



@Configuration

public class Twiloconfig {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Value("${twilio.whatsapp.phone.number}")
    private String whatsappPhoneNumber;

    public String getTwilioPhoneNumber() {
        return twilioPhoneNumber;
    }
    public String getWhatsappPhoneNumber() {
        return whatsappPhoneNumber;
    }

    @PostConstruct
    private void initTwilio() {
        Twilio.init(accountSid, authToken);
        System.out.println("Twilio initialized successfully!");
    }
}
