package wedsan.task5.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wedsan.task5.dto.response.BasicErrorMessage;
import wedsan.task5.dto.response.RequestErrorResponse;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createBasicMessageError(e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleError400(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(createBasicMessageError(ex.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleBusinessRole(ValidationException ex) {
        return ResponseEntity.badRequest().body(createBasicMessageError(ex.getMessage()));
    }

    private RequestErrorResponse createBasicMessageError(String errorMessage) {
        BasicErrorMessage eMessage = new BasicErrorMessage(errorMessage);
        return new RequestErrorResponse(eMessage);
    }

}
