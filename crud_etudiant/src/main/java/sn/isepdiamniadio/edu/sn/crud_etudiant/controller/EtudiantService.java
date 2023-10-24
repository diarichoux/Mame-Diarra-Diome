package sn.isepdiamniadio.edu.sn.crud_etudiant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sn.isepdiamniadio.edu.sn.crud_etudiant.bean.jdbcTemplate;
import sn.isepdiamniadio.edu.sn.crud_etudiant.repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    private JdbcTemplate jdbcTemplate;

    public List<Etudiant> mesEtudiants() {

        String sql = "select * from  etudiant";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Etudiant.class));
    }

    public List<Etudiant> listerEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant creerEtudiant(String nom, String prenom ,String email) {
        Etudiant etudiant = new Etudiant(nom, prenom,email);
        return etudiantRepository.save(etudiant);
    }

    public Optional<Etudiant> obtenirEtudiantParId(Long id) {
        return etudiantRepository.findById(id);
    }

    public Etudiant modifierEtudiant(Long id, String nom, String prenom) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);
        if (optionalEtudiant.isPresent()) {
            Etudiant etudiant = optionalEtudiant.get();
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            return etudiantRepository.save(etudiant);
        }
        return null; // Étudiant non trouvé
    }

    public boolean supprimerEtudiant(Long id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteById(id);
            return true; // Étudiant supprimé avec succès
        }
        return false; // Étudiant non trouvé
    }
}
