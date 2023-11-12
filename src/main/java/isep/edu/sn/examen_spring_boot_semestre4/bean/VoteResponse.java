package isep.edu.sn.examen_spring_boot_semestre4.bean;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Candidate;

public class VoteResponse {
    private String voterId;
    private String candidateId;
    private String message;
    // Constructeurs et getters
    public VoteResponse(String voterId, String candidateId, String message) {
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.message = message;
    }

    public VoteResponse(String voterId, Candidate candidateId, String voteEnregistréAvecSuccès) {
    }

    public String getVoterId() {
        return voterId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getMessage() {
        return message;
    }
}

