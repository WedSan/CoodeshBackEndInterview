package wedsan.task5.model.medicalAppointment;

import jakarta.persistence.*;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.Patient;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEDICAL_APPOINTMENT_CANCELED")
public class MedicalAppointmentCanceled {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @Column(name = "date_medical_appointment")
    private LocalDateTime date;

    private String cancellationReason;

    private LocalDateTime canceledDate;

    public MedicalAppointmentCanceled() {
        super();
        canceledDate = LocalDateTime.now();
    }

    public MedicalAppointmentCanceled(MedicalAppointment medicalAppointment, String cancellationReason) {
        this.id = medicalAppointment.getId();
        this.doctor = medicalAppointment.getMedic();
        this.patient = medicalAppointment.getPatient();
        this.date = medicalAppointment.getDate();
        this.canceledDate = LocalDateTime.now();
        this.cancellationReason = cancellationReason;
    }

    public MedicalAppointmentCanceled(Long id, Doctor doctor, Patient patient, LocalDateTime date, String cancellationReason) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
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
