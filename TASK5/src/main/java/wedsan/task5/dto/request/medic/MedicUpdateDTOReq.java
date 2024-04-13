package wedsan.task5.dto.request.medic;

import jakarta.validation.constraints.NotNull;
import wedsan.task5.dto.request.AddressDTORequest;
import wedsan.task5.model.Address;

public record MedicUpdateDTOReq(
    @NotNull
    Long id,
    String name,
    String phone,
    AddressDTORequest address
) {
}
