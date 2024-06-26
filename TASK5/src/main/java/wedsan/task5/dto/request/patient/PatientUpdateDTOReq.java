package wedsan.task5.dto.request.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wedsan.task5.dto.request.AddressDTORequest;
/**
 * Represents a request Data Transfer Object for updating patient information.
 */
public record PatientUpdateDTOReq(
        @NotBlank
       String name,
        @NotBlank
        String phone,
        @Valid
        AddressDTORequest address
) {

}
