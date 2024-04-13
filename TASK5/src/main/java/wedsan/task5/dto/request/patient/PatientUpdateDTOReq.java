package wedsan.task5.dto.request.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import wedsan.task5.dto.request.AddressDTORequest;

public record PatientUpdateDTOReq(
        @NotNull
        Long id,
        @NotBlank
       String name,
        @NotBlank
        String phone,
        @NotBlank
        AddressDTORequest address
) {

}
