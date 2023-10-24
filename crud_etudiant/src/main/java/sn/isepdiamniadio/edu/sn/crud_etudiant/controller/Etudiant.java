package sn.isepdiamniadio.edu.sn.crud_etudiant.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Etudiant {
    @Id
    private Integer id;// Clé primaire
    private String nom;
    private String prenom;
    private String email;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Constructeur par défaut (constructeur sans argument) pour JPA
    public Etudiant() {
    }
    public Etudiant(String nom, String prenom ,String email) {
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;

    }
    // Getters et setters pour id, nom et prenom
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}