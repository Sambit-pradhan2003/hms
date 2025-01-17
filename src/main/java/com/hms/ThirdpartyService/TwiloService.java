package com.hms.ThirdpartyService;
import com.hms.config.Twiloconfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwiloService {
    private final Twiloconfig twilioConfig;

    @Autowired
    public TwiloService(Twiloconfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public String sendMessage(String to, String messageBody) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(to), // To number
                    new PhoneNumber(twilioConfig.getTwilioPhoneNumber()), // From number
                    messageBody // Message body
            ).create();

            return "Message sent successfully with SID: " + message.getSid();
        } catch (Exception e) {
            return "Error sending message: " + e.getMessage();
        }
    }

    public String sendWhatsAppMessage(String to, String messageBody) {
        try {
            Message message = Message.creator(
                    new PhoneNumber("whatsapp:" + to), // To number (prefixed with 'whatsapp:')
                    new PhoneNumber(twilioConfig.getWhatsappPhoneNumber()), // WhatsApp From number
                    messageBody // Message body
            ).create();

            return "WhatsApp message sent successfully with SID: " + message.getSid();
        } catch (Exception e) {
            return "Error sending WhatsApp message: " + e.getMessage();
        }
    }
}
