package wedsan.task5.model.medicalAppointment;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import wedsan.task5.model.Medic;
import wedsan.task5.model.Patient;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEDICAL_APPOINTMENT_CANCELED")
public class MedicalAppointmentCanceled extends MedicalAppointment {

    private String cancellationReason;

    private LocalDateTime canceledDate;

    public MedicalAppointmentCanceled() {
        super();
        canceledDate = LocalDateTime.now();
    }

    public MedicalAppointmentCanceled(MedicalAppointment medicalAppointment, String cancellationReason) {
        super(medicalAppointment.getId(),
                medicalAppointment.getMedic(),
                medicalAppointment.getPatient(),
                medicalAppointment.getDate());
        this.canceledDate = LocalDateTime.now();
        this.cancellationReason = cancellationReason;
    }

    public MedicalAppointmentCanceled(Long id, Medic medic, Patient patient, LocalDateTime date, String cancellationReason) {
        super(id, medic, patient, date);
        this.canceledDate = LocalDateTime.now();
        this.cancellationReason = cancellationReason;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancelationReason) {
        this.cancellationReason = cancelationReason;
    }

    public LocalDateTime getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(LocalDateTime canceledDate) {
        this.canceledDate = canceledDate;
    }
}
