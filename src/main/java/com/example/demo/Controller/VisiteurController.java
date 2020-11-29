package com.example.demo.Controller;

import com.example.demo.Model.Mail;
import com.example.demo.Model.Visiteur;

import com.example.demo.Repository.VisiteurRepository;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Visiteur")

public class VisiteurController {
    @Autowired
    private MailService mailService;
    @Autowired
    private VisiteurRepository visiteurRepository;
    @Autowired
    AccountService accountService;
    @GetMapping("/All")
    public List<Visiteur> listVisiteur(){
        return visiteurRepository.findAll();

    }
    @PostMapping("/save")
    public Visiteur saveVille(@RequestBody Visiteur c){
        return accountService.saveVisiteur(c);
    }
    @PutMapping("/modif/{id}")
    public Visiteur modif (@RequestBody  Visiteur visiteur, @PathVariable Long id){
        visiteur.setId(id);
        return visiteurRepository.saveAndFlush(visiteur);

    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            visiteurRepository.deleteById(id);
            hashMap.put("etat", "Visiteur supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Visiteur non supprimé");
            return  hashMap;
        }
    }
    @PostMapping(value="/sendMail")
    public String sendMail(@RequestBody Mail mail)
    {
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");
        mail.setFrom("omar.bchir12@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject("Reponse pour votre Reclamation");
        mail.setContent(mail.getContent());
        mailService.sendSimpleMessage(mail);
        return ("email ok");
    }
}
