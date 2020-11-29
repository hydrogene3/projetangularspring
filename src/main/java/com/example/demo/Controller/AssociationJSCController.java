package com.example.demo.Controller;

import com.example.demo.Model.AssociationJSC;
import com.example.demo.Repository.AssociationRepository;
import com.example.demo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/AssociationJSC")
public class AssociationJSCController {
    @Autowired
    private AssociationRepository associationJSCRepository;
    @Autowired
    AccountService accountService;
    @GetMapping("/All")
    public List<AssociationJSC> listAssociation(){
        return associationJSCRepository.findAll();

    }
    @PostMapping("/save")
    public AssociationJSC saveAssociationJSC(@RequestBody AssociationJSC c){
        return accountService.saveAssociationJSC(c);
    }
    @PutMapping("/modif/{id}")
    public AssociationJSC modif (@RequestBody  AssociationJSC associationJSC, @PathVariable Long id){
        associationJSC.setId(id);
        return associationJSCRepository.saveAndFlush(associationJSC);

    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            associationJSCRepository.deleteById(id);
            hashMap.put("etat", "Administrateur supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Administrateur non supprimé");
            return  hashMap;
        }
    }

}
