package com.example.demo.Controller;

import com.example.demo.Model.Administrateur;
import com.example.demo.Repository.AdministrateurRepository;
import com.example.demo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Administrateur")

public class AdministrateurController {
    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    AccountService  accountService;
    @GetMapping("/All")
    public List<Administrateur> listActivite(){
        return administrateurRepository.findAll();

    }
    @PostMapping("/save")
    public Administrateur saveAdministrateur(@RequestBody Administrateur c){
        return accountService.saveAdmin(c);
    }
    @PutMapping("/modif/{id}")
    public Administrateur modif (@RequestBody  Administrateur administrateur, @PathVariable Long id){
        administrateur.setId(id);
        return administrateurRepository.saveAndFlush(administrateur);

    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            administrateurRepository.deleteById(id);
            hashMap.put("etat", "Administrateur supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Administrateur non supprimé");
            return  hashMap;
        }
    }
}
