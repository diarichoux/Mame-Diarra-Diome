package isep.edu.sn.examen_spring_boot_semestre4.controller;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Candidate;
import isep.edu.sn.examen_spring_boot_semestre4.repository.NotBlank;

import java.time.LocalDate;
public class VoteDTO {
    @NotBlank(message = "VoterId ne peut pas être vide")
    private String voterId;

    @NotBlank(message = "CandidateId ne peut pas être vide")
    private String candidateId;
    private  String name;
    private String nationalId;
    private  String dateOfBirth;
    private String  password;

    // Getters and setters

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return  name;
    }
    public String getNationalId(){
        return nationalId;

    }
    public LocalDate getDateOfBirth(){
        return LocalDate.parse(dateOfBirth);
    }
    public String getPassword(){
        return password;

    }

}
