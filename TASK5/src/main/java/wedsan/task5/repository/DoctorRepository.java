package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.MedicalSpecialty;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository interface for managing doctors.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Check if a doctor with the specified ID exists.
     *
     * @param id The ID of the doctor.
     * @return true if a doctor with the specified ID exists, false otherwise.
     */
    boolean existsDoctorById(long id);

    /**
     * Choose a random doctor of the specified medical specialty who is available on the given date.
     *
     * @param medicalSpecialty The medical specialty of the doctor.
     * @param date             The date for which to choose the doctor.
     * @return A random doctor of the specified medical specialty who is available on the given date.
     */
    @Query("""
            select d from Doctor d
            where
            d.specialty = :medicalSpecialty
            and
            d.id not in(
                select ma.doctor.id from MedicalAppointment ma
                where
                ma.date = :date
            )
            order by rand()
            limit 1
        """)
    Doctor chooseRandomDoctorOnDate(MedicalSpecialty medicalSpecialty, LocalDateTime date);

    /**
     * Check if a doctor with the specified email exists.
     *
     * @param email The email of the doctor.
     * @return true if a doctor with the specified email exists, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Check if a doctor with the specified medical document exists.
     *
     * @param medicDocument The medical document of the doctor.
     * @return true if a doctor with the specified medical document exists, false otherwise.
     */
    boolean existsByMedicDocument(String medicDocument);

    /**
     * Get a doctor by ID.
     *
     * @param id The ID of the doctor.
     * @return An Optional containing the doctor with the specified ID, or empty if not found.
     */
    Optional<Doctor> getDoctorById(Long id);
}