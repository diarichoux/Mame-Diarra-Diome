package isep.edu.sn.examen_spring_boot_semestre4.controller;

public class VoterNotFoundException extends RuntimeException {
    public VoterNotFoundException(String message) {
        super(message);
    }
}
