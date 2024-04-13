package wedsan.task5.model.medicalAppointment;

import jakarta.persistence.*;
import wedsan.task5.model.Medic;
import wedsan.task5.model.Patient;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEDICAL_APPOINTMENT")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Patient patient;

    @Column(name = "date_medical_appointment")
    private LocalDateTime date;

    public MedicalAppointment() {
    }

    public MedicalAppointment(Long id, Medic medic, Patient patient, LocalDateTime date) {
        this.id = id;
        this.medic = medic;
        this.patient = patient;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
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
