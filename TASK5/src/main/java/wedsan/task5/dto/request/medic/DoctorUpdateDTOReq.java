package wedsan.task5.dto.request.medic;

import wedsan.task5.dto.request.AddressDTORequest;

/**
 * Represents a request Data Transfer Object for updating doctor information.
 */
public record DoctorUpdateDTOReq(
    String name,
    String phone,
    AddressDTORequest address
) {
}
