package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.Patient;

import java.util.Optional;

/**
 * Repository interface for accessing patient data.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    /**
     * Finds a patient by document.
     * @param document The document number of the patient.
     * @return An optional containing the patient if found, empty otherwise.
     */
    Optional<Patient> findByDocument(String document);

    /**
     * Finds a patient by ID.
     * @param id The ID of the patient.
     * @return An optional containing the patient if found, empty otherwise.
     */
    Optional<Patient> findById(int id);

    /**
     * Checks if a patient exists by ID.
     * @param id The ID of the patient.
     * @return True if the patient exists, false otherwise.
     */
    boolean existsPatientById(Long id);

    /**
     * Checks if a patient exists by email.
     * @param email The email address of the patient.
     * @return True if a patient with the email exists, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Checks if a patient exists by document.
     * @param document The document number of the patient.
     * @return True if a patient with the document exists, false otherwise.
     */
    boolean existsByDocument(String document);
}
