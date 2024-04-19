package wedsan.task5.dto.request.medic;

import wedsan.task5.dto.request.AddressDTORequest;

public record DoctorUpdateDTOReq(
    String name,
    String phone,
    AddressDTORequest address
) {
}
