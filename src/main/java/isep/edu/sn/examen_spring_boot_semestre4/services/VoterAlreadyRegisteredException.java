package isep.edu.sn.examen_spring_boot_semestre4.services;

public class VoterAlreadyRegisteredException extends Exception {

    public VoterAlreadyRegisteredException(String message) {
        super(message);
    }
}
