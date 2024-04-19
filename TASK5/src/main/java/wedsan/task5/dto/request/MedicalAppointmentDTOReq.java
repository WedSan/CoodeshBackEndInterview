package wedsan.task5.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import wedsan.task5.model.MedicalSpecialty;

import java.time.LocalDateTime;
/**
 * Represents a request Data Transfer Object for creating a medical appointment.
 */
public record MedicalAppointmentDTOReq(
        Long idDoctor,

        @NotNull
        Long idPatient,

        @NotNull
        @Future
        LocalDateTime date,

        @NotNull
        MedicalSpecialty medicalSpecialty
) {
}
