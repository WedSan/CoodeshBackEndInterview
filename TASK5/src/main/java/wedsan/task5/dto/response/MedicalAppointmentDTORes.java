package wedsan.task5.dto.response;

import wedsan.task5.model.medicalAppointment.MedicalAppointment;

import java.time.LocalDateTime;

/**
 * Represents a response Data Transfer Object for a medical appointment entity.
 */
public record MedicalAppointmentDTORes(
        Long id,
        Long idDoctor,
        Long idPatient,
        LocalDateTime date
) {
    public MedicalAppointmentDTORes(MedicalAppointment medicalAppointment) {
        this(medicalAppointment.getId(),
                medicalAppointment.getMedic().getId(),
                medicalAppointment.getPatient().getId(),
                medicalAppointment.getDate());
    }
}
