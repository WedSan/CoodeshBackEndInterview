package wedsan.task5.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * Represents a request DTO Data Transfer Object for cancelling a medical appointment.
 */
public record MedAppointmentCancellationDTOReq(
        @NotNull
        String cancellationReason
) {

}
