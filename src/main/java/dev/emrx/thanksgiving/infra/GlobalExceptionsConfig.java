package dev.emrx.thanksgiving.infra;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import dev.emrx.thanksgiving.infra.exception.ValidationIntegrity;
import jakarta.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionsConfig {
  
  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<String> handleError404() {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<DataErrorValidation>> handleError400(MethodArgumentNotValidException ex) {

      var errors = ex.getFieldErrors().stream().map(DataErrorValidation::new).toList();
      return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(ValidationIntegrity.class)
  public ResponseEntity<String> errorHandlerValidacionDeIntegridad(ValidationIntegrity ex) {
      return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<String> handleValidationException(ValidationException ex) {
      return ResponseEntity.badRequest().body(ex.getMessage());
  }

  private record DataErrorValidation(String field, String error) {

      public DataErrorValidation(FieldError error) {
          this(error.getField(), error.getDefaultMessage());
      }

  }

}
