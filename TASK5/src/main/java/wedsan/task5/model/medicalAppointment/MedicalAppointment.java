package wedsan.task5.model.medicalAppointment;

import jakarta.persistence.*;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.Patient;

import java.time.LocalDateTime;

/**
 * Represents a medical appointment in the system.
 */
@Entity
@Table(name = "TB_MEDICAL_APPOINTMENT")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @Column(name = "date_medical_appointment")
    private LocalDateTime date;

    public MedicalAppointment() {
    }

    public MedicalAppointment(Long id, Doctor doctor, Patient patient, LocalDateTime date) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getMedic() {
        return doctor;
    }

    public void setMedic(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
