package isep.edu.sn.examen_spring_boot_semestre4.controller;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Candidate;
import isep.edu.sn.examen_spring_boot_semestre4.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @GetMapping
    public ResponseEntity<List<Candidate>> getCandidates() {
        List<Candidate> candidates = candidateService.getCandidates();
        return ResponseEntity.ok(candidates);
    }

}
