package com.example.demo.Controller;

import com.example.demo.Model.Ville;
import com.example.demo.Repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Ville")

public class VilleController {
    @Autowired
    private VilleRepository villeRepository;
    @GetMapping("/All")
    public List<Ville> listVille(){
        return villeRepository.findAll();

    }
    @PostMapping("/save")
    public Ville saveVille(@RequestBody Ville c){
        return villeRepository.save(c);
    }
    @PutMapping("/modif/{id}")
    public Ville modif (@RequestBody  Ville ville, @PathVariable Long id){
        ville.setId_ville(id);
        return villeRepository.saveAndFlush(ville);

    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            villeRepository.deleteById(id);
            hashMap.put("etat", "Ville supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Ville non supprimé");
            return  hashMap;
        }
    }

}
