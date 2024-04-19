package wedsan.task5.dto.request.medic;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import wedsan.task5.dto.request.AddressDTORequest;
import wedsan.task5.model.MedicalSpecialty;

/**
 * Represents a request DTO Data Transfer Object for creating a doctor.
 */
public record DoctorDTOReq(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String medicDocument,
        @NotNull
        @Enumerated(EnumType.STRING)
        MedicalSpecialty specialty,

        @NotNull @Valid AddressDTORequest address
) {
}
