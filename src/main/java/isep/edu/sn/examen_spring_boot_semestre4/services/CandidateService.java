package isep.edu.sn.examen_spring_boot_semestre4.services;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Candidate;
import isep.edu.sn.examen_spring_boot_semestre4.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }
}
