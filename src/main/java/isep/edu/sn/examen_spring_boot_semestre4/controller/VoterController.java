// VoterController.java

package isep.edu.sn.examen_spring_boot_semestre4.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import isep.edu.sn.examen_spring_boot_semestre4.services.VoterAlreadyRegisteredException;
import isep.edu.sn.examen_spring_boot_semestre4.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<String> registerVoter(@RequestBody VoteDTO voterDTO) throws VoterAlreadyRegisteredException {
        voterService.registerVoter(voterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enregistré avec succès");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginVoter(@RequestBody VoteDTO voterDTO) {
        try {
            String token = voterService.loginVoter(voterDTO);
            return ResponseEntity.ok(new LoginResponse(token, voterDTO.getVoterId(), "Connecté avec succès"));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de l'authentification");
        }
    }

    @DeleteMapping("/{voterId}")
    public ResponseEntity<String> deleteVoter(@PathVariable String voterId) throws VoterNotFoundException {
        voterService.deleteVoter(voterId);
        return ResponseEntity.ok("Électeur supprimé avec succès");
    }

    @PutMapping("/{voterId}")
    public ResponseEntity<String> updateVoter(@PathVariable String voterId, @RequestBody
    VoteDTO updatedVoterDTO) throws VoterNotFoundException {
        voterService.updateVoter(voterId, updatedVoterDTO);
        return ResponseEntity.ok("Électeur mis à jour avec succès");
    }

    private void authenticate(String voterId, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(voterId, password));
    }

    private String generateToken(VoterService userDetails) {
        String secretKey = "VotreCleSecrete"; // Remplacez par votre clé secrète réelle
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();

        return token;
    }
}

