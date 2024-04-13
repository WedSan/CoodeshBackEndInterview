package wedsan.task5.dto.response;

import wedsan.task5.model.medicalAppointment.MedicalAppointment;

import java.time.LocalDateTime;

public record MedicalAppointmentDTORes(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data
) {
    public MedicalAppointmentDTORes(MedicalAppointment medicalAppointment) {
        this(medicalAppointment.getId(),
                medicalAppointment.getMedic().getId(),
                medicalAppointment.getPatient().getId(),
                medicalAppointment.getDate());
    }
}
