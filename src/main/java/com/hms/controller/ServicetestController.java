package com.hms.controller;

import com.hms.ThirdpartyService.EmailService;
import com.hms.ThirdpartyService.S3Bucketservice;
import com.hms.ThirdpartyService.TwiloService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/test")
public class ServicetestController {
    private S3Bucketservice     s3Bucketservice;
    private TwiloService    twiloService;
    private EmailService emailService;


    public ServicetestController(S3Bucketservice s3Bucketservice,TwiloService twiloService,EmailService emailService) {
        this.s3Bucketservice = s3Bucketservice;
        this.twiloService = twiloService;
        this.emailService = emailService;
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestBody MultipartFile file) throws IOException {


        String fileUrl = s3Bucketservice.uploadFile(file);

        return "File uploaded: " + fileUrl;
    }

    @PostMapping("/send")
    public String sendMessage(
            @RequestParam String to,
            @RequestParam String message) {
        String message1 = twiloService.sendMessage(to, message);
        String message2 = twiloService.sendWhatsAppMessage(to, message);
        return message1 + "\n" + message2;

    }

    @PostMapping("/sendmail")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        return emailService.sendEmail(to, subject, body);
    }

}
