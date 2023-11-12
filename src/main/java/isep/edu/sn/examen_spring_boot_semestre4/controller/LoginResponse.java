package isep.edu.sn.examen_spring_boot_semestre4.controller;

public class LoginResponse {
    private String token;
    private String voterId;
    private String message;

    public LoginResponse(String token, String voterId, String message) {
        this.token = token;
        this.voterId = voterId;
        this.message = message;
    }

    // Getters and setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
