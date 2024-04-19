package wedsan.task5.dto.response;


/**
 * Represents a response containing an error message.
 */
public record RequestErrorResponse(
        BasicErrorMessage error
) {
}
