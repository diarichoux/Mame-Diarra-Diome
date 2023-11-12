package isep.edu.sn.examen_spring_boot_semestre4.configuration;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Voter;
import isep.edu.sn.examen_spring_boot_semestre4.repository.VoterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private VoterRepository voterRepository;

    public void CustomUserDetailsService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public UserDetailsService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String voterId) throws UsernameNotFoundException {
        Voter voter = voterRepository.findByVoterId(voterId)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'ID de l'électeur : " + voterId)).getVoter();

        return new org.springframework.security.core.userdetails.User(
                voter.getVoterId(),
                voter.getPassword(),
                // Ajoutez les rôles ou autorités appropriés ici si nécessaire
                new ArrayList<>()
        );
    }
}
