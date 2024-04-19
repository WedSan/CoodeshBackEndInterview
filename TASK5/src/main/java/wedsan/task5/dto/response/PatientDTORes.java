package wedsan.task5.dto.response;

import wedsan.task5.model.Address;
import wedsan.task5.model.Patient;

public record PatientDTORes(
        Long id, String name,
        String email,
        String document,
        String phone,
        Address address
) {
    public PatientDTORes(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getDocument(), patient.getPhone(), patient.getAddress());
    }
}
