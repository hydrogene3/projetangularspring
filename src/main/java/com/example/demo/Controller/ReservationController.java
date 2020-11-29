package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Repository.EvenementRepository;
import com.example.demo.Repository.VisiteurRepository;

import com.example.demo.Repository.ReservationRepository;
import com.example.demo.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/Reservation")
@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private VisiteurRepository visiteurRepository;
    @Autowired
    private MailService mailService;
    @GetMapping("/All")
    public List<Reservation> listReservation() {
        return reservationRepository.findAll();

    }
    @GetMapping("/Accepterreservation/{idreservation}")
    public Reservation accepterreservation( @PathVariable Long idreservation) {
        Reservation reservation=reservationRepository.getOne(idreservation);
        reservation.setAccepete(true);
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");
        Mail mail=new Mail();
        mail.setFrom("omar.bchir12@gmail.com");
        mail.setTo(reservation.getVisiteur().getUsername());
        mail.setSubject("Reponse pour votre Reclamation");
        mail.setContent("votre reservation accepter");
        mailService.sendSimpleMessage(mail);
        return reservationRepository.save(reservation);

    }

    @PostMapping("/save/{idvisteur}/{idevent}")
    public Reservation saveReservation(@RequestBody Reservation c, @PathVariable Long idvisteur, @PathVariable Long idevent) {
        Visiteur visiteur = visiteurRepository.getOne(idvisteur);
        c.setVisiteur(visiteur);
        c.setAccepete(false);
        Evenement evenement = evenementRepository.getOne(idevent);
        c.setEvenement(evenement);
        return reservationRepository.save(c);
    }

    @PutMapping("/modif/{id}}")
    public Reservation modif(@RequestBody Reservation reservation, @PathVariable Long id) {
        reservation.setId_res(id);

        return reservationRepository.saveAndFlush(reservation);

    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> delete(@PathVariable Long id) {
        HashMap hashMap = new HashMap();
        try {
            reservationRepository.deleteById(id);
            hashMap.put("etat", "reservation supprimé");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "reservation non supprimé");
            return hashMap;
        }
    }
}
