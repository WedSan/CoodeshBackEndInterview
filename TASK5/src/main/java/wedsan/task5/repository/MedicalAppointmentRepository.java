package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;

import java.time.LocalDateTime;

/**
 * Repository interface for accessing medical appointment data.
 */
@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
    /**
     * Checks if a medical appointment exists for a patient between the specified time range.
     * @param patientId The ID of the patient.
     * @param firstHour The start of the time range.
     * @param lastHour The end of the time range.
     * @return True if a medical appointment exists for the patient within the specified time range, false otherwise.
     */
    boolean existsByPatientIdAndDateBetween(Long patientId, LocalDateTime firstHour, LocalDateTime lastHour);

    /**
     * Checks if a medical appointment exists for a doctor on a specific date.
     * @param medicId The ID of the doctor.
     * @param date The date of the medical appointment.
     * @return True if a medical appointment exists for the doctor on the specified date, false otherwise.
     */
    boolean existsMedicalAppointmentByDoctorIdAndDate(Long medicId, LocalDateTime date);
}
