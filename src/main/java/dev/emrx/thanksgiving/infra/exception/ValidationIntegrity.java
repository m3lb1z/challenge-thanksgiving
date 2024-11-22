package dev.emrx.thanksgiving.infra.exception;

public class ValidationIntegrity extends RuntimeException {

    public ValidationIntegrity(String message) {
        super(message);
    }
  
}
