package isep.edu.sn.examen_spring_boot_semestre4.repository;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Vote;
import isep.edu.sn.examen_spring_boot_semestre4.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire

    Optional<Vote> findByVoterId(String voterId);

    boolean existsByVoterId(String voterId);

}
