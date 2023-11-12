package isep.edu.sn.examen_spring_boot_semestre4.controller;

import isep.edu.sn.examen_spring_boot_semestre4.bean.VoteResponse;
import isep.edu.sn.examen_spring_boot_semestre4.services.VoterAlreadyRegisteredException;
import isep.edu.sn.examen_spring_boot_semestre4.services.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// VotingController.java
@RestController
@RequestMapping("/api/voting")
public class VotingController {
    @Autowired
    private VotingService votingService;
    @PostMapping("/cast-vote")
    public ResponseEntity<?> castVote(@RequestBody VoteDTO voteDTO) {
        try {
            votingService.castVote(voteDTO);
        } catch (VoterAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(new VoteResponse(voteDTO.getVoterId(), voteDTO.getCandidateId(),
                "Vote enregistré avec succès"));
    }
}

