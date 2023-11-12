// VoterService.java

package isep.edu.sn.examen_spring_boot_semestre4.services;

import isep.edu.sn.examen_spring_boot_semestre4.controller.VoteDTO;
import isep.edu.sn.examen_spring_boot_semestre4.controller.VoterNotFoundException;
import isep.edu.sn.examen_spring_boot_semestre4.entity.Voter;
import isep.edu.sn.examen_spring_boot_semestre4.repository.VoterRepository;
import isep.edu.sn.examen_spring_boot_semestre4.tokens.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenProvider;

    public String loginVoter(VoteDTO voterDTO) {
        authenticate(voterDTO.getVoterId(), voterDTO.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(voterDTO.getVoterId());
        return jwtTokenProvider.generateToken(userDetails);
    }

    private void authenticate(String voterId, String password) throws AuthenticationException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(voterId, password));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Identifiants incorrects", e);
        }
    }

    public Voter registerVoter(VoteDTO voterDTO) throws VoterAlreadyRegisteredException {
        if (voterRepository.existsByVoterId(voterDTO.getVoterId())) {
            throw new VoterAlreadyRegisteredException("Cet électeur est déjà enregistré.");
        }

        Voter newVoter = new Voter();
        newVoter.setName(voterDTO.getName());
        newVoter.setNationalId(voterDTO.getNationalId());
        newVoter.setDateOfBirth(voterDTO.getDateOfBirth());
        newVoter.setVoterId(voterDTO.getVoterId());
        newVoter.setPassword(passwordEncoder.encode(voterDTO.getPassword()));

        return voterRepository.save(newVoter);
    }

    public void deleteVoter(String voterId) throws VoterNotFoundException {
        Voter voter = voterRepository.findByVoterId(voterId)
                .orElseThrow(() -> new VoterNotFoundException("Électeur non trouvé avec l'ID : " + voterId)).getVoter();
        voterRepository.delete(voter);
    }

    public void updateVoter(String voterId, VoteDTO updatedVoterDTO) throws VoterNotFoundException {
        Voter voter = voterRepository.findByVoterId(voterId)
                .orElseThrow(() -> new VoterNotFoundException("Électeur non trouvé avec l'ID : " + voterId)).getVoter();
        voter.setName(updatedVoterDTO.getName());
        voter.setNationalId(updatedVoterDTO.getNationalId());
        voter.setDateOfBirth(updatedVoterDTO.getDateOfBirth());
        voter.setPassword(passwordEncoder.encode(updatedVoterDTO.getPassword()));
        voterRepository.save(voter);
    }

    public String getUsername(String voterId) throws VoterNotFoundException {
        Voter voter = voterRepository.findByVoterId(voterId)
                .orElseThrow(() -> new VoterNotFoundException("Électeur non trouvé avec l'ID : " + voterId)).getVoter();
        return voter.getName();
    }

    public String getUsername() {
        return null;
    }
}
