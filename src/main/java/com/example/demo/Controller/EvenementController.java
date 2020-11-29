package com.example.demo.Controller;

import com.example.demo.Model.Activite;
import com.example.demo.Model.Evenement;
import com.example.demo.Model.AssociationJSC;
import com.example.demo.Model.Ville;
import com.example.demo.Repository.ActiviteRepository;
import com.example.demo.Repository.EvenementRepository;
import com.example.demo.Repository.AssociationRepository;

import com.example.demo.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Evenement")

public class EvenementController {
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private ActiviteRepository activiteRepository;
    @Autowired
    private VilleRepository villeRepository;
    @GetMapping("/All")
    public List<Evenement> listEvenement(){
        return evenementRepository.findAll();

    }
    @GetMapping("/gteone/{Id}")
    public Evenement getone( @PathVariable Long Id) {
        return evenementRepository.getOne(Id);
    }
    @PostMapping("/save/{idassoc}/{idville}")
    public Evenement evenementsave(@RequestBody Evenement c, @PathVariable Long idassoc, @PathVariable Long idville){
        AssociationJSC associationJSC = associationRepository.getOne(idassoc);
        c.setAssociationJSC(associationJSC);
        Ville ville = villeRepository.getOne(idville);
        c.setVilles(ville);
        return evenementRepository.save(c);
    }
    @PostMapping("/addactivte/{idevnment}/{idactivite}")
    public Evenement addactivte( @PathVariable Long idevnment,@PathVariable Long idactivite){
 Evenement evenement=evenementRepository.getOne(idevnment);
        Activite activite = activiteRepository.getOne(idactivite);
        List<Activite> activiteList=evenement.getActiviteList();
        activiteList.add(activite);


        return evenementRepository.save(evenement);
    }
    @PutMapping("/modif/{id}")
    public Evenement modif (@RequestBody  Evenement evenement, @PathVariable Long id){
        evenement.setId_event(id);
        return evenementRepository.saveAndFlush(evenement);

    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            evenementRepository.deleteById(id);
            hashMap.put("etat", "Ville supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Ville non supprimé");
            return  hashMap;
        }
    }
}
