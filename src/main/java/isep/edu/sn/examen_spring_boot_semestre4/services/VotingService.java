package isep.edu.sn.examen_spring_boot_semestre4.services;

import isep.edu.sn.examen_spring_boot_semestre4.controller.VoteDTO;
import isep.edu.sn.examen_spring_boot_semestre4.entity.Vote;
import isep.edu.sn.examen_spring_boot_semestre4.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotingService {

    private final VoterRepository voteRepository;

    @Autowired
    public VotingService(VoterRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public void castVote(VoteDTO voteDTO) throws VoterAlreadyRegisteredException {
        // Vérifiez si l'électeur a déjà voté en utilisant le VoterRepository
        if (voterHasVoted(voteDTO.getVoterId())) {
            throw new VoterAlreadyRegisteredException("L'électeur a déjà voté");
        }

        // Créez une nouvelle instance de l'entité Vote à partir des données du DTO
        Vote newVote = new Vote();
        newVote.setVoterId(voteDTO.getVoterId());
        newVote.setCandidate(voteDTO.getCandidateId());

    }

    // Logique pour vérifier si l'électeur a déjà voté
    private boolean voterHasVoted(String voterId) {
        Optional<Vote> voteOptional = voteRepository.findByVoterId(voterId);
        return voteOptional.isPresent();
    }
}
