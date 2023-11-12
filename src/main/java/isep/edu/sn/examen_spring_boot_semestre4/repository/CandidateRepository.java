package isep.edu.sn.examen_spring_boot_semestre4.repository;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByName(String name);
    List<Candidate> findByParty(String party);
    List<Candidate> findTop3ByOrderByVoteDateDesc();
}
