package wedsan.task5.dto.request.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import wedsan.task5.dto.request.AddressDTORequest;
import wedsan.task5.model.MedicalSpecialty;

public record MedicDTOReq(
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
        MedicalSpecialty specialty,

        @NotNull @Valid AddressDTORequest address
) {
}
