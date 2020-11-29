package com.example.demo.Controller;

import com.example.demo.Model.Mail;
import com.example.demo.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MailRestController {
    @Autowired
    private MailService mailService;
    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    public String sendMail(){
        System.out.println("Spring Mail - Sending simple Email with JavaMailSender Exemple");
        Mail mail = new Mail();
        mail.setFrom("omar.bchir12@gmail.com");
        mail.setTo("omar.bchir12@gmail.com");
        mail.setSubject("Sending simple Email with javaMailsender exemple");
        mail.setContent("this tuto demonstration how to send a simple email using spring framework");
        mailService.sendSimpleMessage(mail);
        return "ok";

    }
}
