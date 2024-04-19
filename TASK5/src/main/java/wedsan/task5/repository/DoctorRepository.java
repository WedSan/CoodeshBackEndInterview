package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.MedicalSpecialty;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsDoctorById(long id);

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

    boolean existsByEmail(String email);

    boolean existsByMedicDocument(String medicDocument);

    Optional<Doctor> getDoctorById(Long id);
}
