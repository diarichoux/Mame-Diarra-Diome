package sn.isepdiamniadio.edu.sn.crud_etudiant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> listerEtudiants() {
        return etudiantService.listerEtudiants();
    }

    @PostMapping
    public Etudiant creerEtudiant(@RequestParam String nom, @RequestParam String prenom,@RequestParam String email) {
        return etudiantService.creerEtudiant(nom, prenom,email);
    }

    @PutMapping("/{id}")
    public Etudiant modifierEtudiant(@PathVariable Long id, @RequestParam String nom, @RequestParam String prenom) {
        return etudiantService.modifierEtudiant(id, nom, prenom);
    }

    @DeleteMapping("/{id}")
    public boolean supprimerEtudiant(@PathVariable Long id) {
        return etudiantService.supprimerEtudiant(id);
    }
}
