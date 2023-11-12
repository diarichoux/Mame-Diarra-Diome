package isep.edu.sn.examen_spring_boot_semestre4.services;

import isep.edu.sn.examen_spring_boot_semestre4.entity.Vote;
import isep.edu.sn.examen_spring_boot_semestre4.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private VoterRepository userRepository; // Assurez-vous que UserRepository est correctement défini

    @Override
    public UserDetails loadUserByUsername(String voterId) throws UsernameNotFoundException {
        Optional<Vote> voter = userRepository.findByVoterId(voterId);
        if (voter.isEmpty()) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'identifiant: " + voterId);
        }
        return new org.springframework.security.core.userdetails.User(voter.get().getVoterId(),
                voter.get().getPassword(), new ArrayList<>());
    }


}
