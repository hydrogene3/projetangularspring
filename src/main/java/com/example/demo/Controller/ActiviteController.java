package com.example.demo.Controller;

import com.example.demo.Model.Activite;
import com.example.demo.Repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Activite")

public class ActiviteController {
    @Autowired
    private ActiviteRepository activiteRepository;
    @GetMapping("/All")
    public List<Activite> listActivite(){
        return activiteRepository.findAll();

    }
    @PostMapping("/save")
    public Activite saveactivite(@RequestBody Activite c){
        return activiteRepository.save(c);
    }
    @PutMapping("/modif/{id}")
    public Activite modif (@RequestBody  Activite activite, @PathVariable Long id){
        activite.setId_act(id);
        return activiteRepository.saveAndFlush(activite);

    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            activiteRepository.deleteById(id);
            hashMap.put("etat", "Activite supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Activite non supprimé");
            return  hashMap;
        }
    }

}
