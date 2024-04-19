package wedsan.task5.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wedsan.task5.dto.response.BasicErrorMessage;
import wedsan.task5.dto.response.RequestErrorResponse;

/**
 * Global exception handler to handle exceptions thrown by controllers.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles EntityNotFoundException by returning a NOT_FOUND response.
     * @param e The EntityNotFoundException.
     * @return ResponseEntity with NOT_FOUND status and error message.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RequestErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(createErrorResponse(e.getMessage()));
    }

    /**
     * Handles HttpMessageNotReadableException by returning a BAD_REQUEST response.
     * @param ex The HttpMessageNotReadableException.
     * @return ResponseEntity with BAD_REQUEST status and error message.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RequestErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                .body(createErrorResponse(ex.getMessage()));
    }

    /**
     * Handles ValidationException by returning a BAD_REQUEST response.
     * @param ex The ValidationException.
     * @return ResponseEntity with BAD_REQUEST status and error message.
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<RequestErrorResponse> handleValidationException(ValidationException ex) {
        return ResponseEntity.badRequest()
                .body(createErrorResponse(ex.getMessage()));
    }

    /**
     * Creates a RequestErrorResponse containing the provided error message.
     * @param errorMessage The error message.
     * @return The RequestErrorResponse containing the error message.
     */
    private RequestErrorResponse createErrorResponse(String errorMessage) {
        BasicErrorMessage basicErrorMessage = new BasicErrorMessage(errorMessage);
        return new RequestErrorResponse(basicErrorMessage);
    }
}
