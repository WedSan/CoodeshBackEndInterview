package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.Patient;

import java.util.Optional;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByDocument(String document);
    Optional<Patient> findById(int id);
    boolean existsPatientById(Long id);
}
