package corp.spgc.mineralwater.exception.handler;

import corp.spgc.mineralwater.exception.definition.EntityDeletingException;
import corp.spgc.mineralwater.exception.definition.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ProblemDetail> entityNotFoundExceptionHandler(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ProblemDetail.
                forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage()));
    }
    @ExceptionHandler(EntityDeletingException.class)
    public ResponseEntity<ProblemDetail> entityDeletingExceptionHandler(EntityDeletingException ex){
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ProblemDetail.
                forStatusAndDetail(HttpStatus.NOT_IMPLEMENTED,ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> defaultExceptionHandler(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ProblemDetail.
                forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
