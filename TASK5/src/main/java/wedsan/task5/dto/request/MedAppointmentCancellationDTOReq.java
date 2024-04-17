package wedsan.task5.dto.request;

import jakarta.validation.constraints.NotNull;

public record MedAppointmentCancellationDTOReq(
        @NotNull
        String cancellationReason
) {

}
