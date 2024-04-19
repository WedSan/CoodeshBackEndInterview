package wedsan.task5.dto.response;

import wedsan.task5.model.Address;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.MedicalSpecialty;

/**
 * Represents a response Data Transfer Object for a doctor entity.
 */
public record DoctorDTORes(
        Long id,
        String name,
        String email,
        String medicalDocument,
        String phone,
        MedicalSpecialty medicalSpecialty,
        Address address
){
    public DoctorDTORes(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getMedicDocument(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
