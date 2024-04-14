package wedsan.task5.model.medicalAppointment;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.model.Medic;
import wedsan.task5.model.Patient;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEDICAL_APPOINTMENT_CANCELED")
public class MedicalAppointmentCanceled extends MedicalAppointment {


    LocalDateTime canceledDate;

    public MedicalAppointmentCanceled() {
        super();
        canceledDate = LocalDateTime.now();
    }

    public MedicalAppointmentCanceled(MedicalAppointment medicalAppointment) {
        super(medicalAppointment.getId(),
                medicalAppointment.getMedic(),
                medicalAppointment.getPatient(),
                medicalAppointment.getDate());
        this.canceledDate = LocalDateTime.now();

    }

    public MedicalAppointmentCanceled(Long id, Medic medic, Patient patient, LocalDateTime date) {
        super(id, medic, patient, date);
        this.canceledDate = LocalDateTime.now();
    }
}
