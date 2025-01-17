package com.hms.ThirdpartyService;


import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Value("${sendgrid.from.email}")
    private String fromEmail;

    private final SendGrid sendGrid;

    @Autowired
    public EmailService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    public String sendEmail(String to, String subject, String body) {
        Email from = new Email(fromEmail);
        Email toEmail = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, toEmail, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);

            return "Email sent successfully with status code: " + response.getStatusCode();
        } catch (IOException ex) {
            return "Error sending email: " + ex.getMessage();
        }
    }
}

