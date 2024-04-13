package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.Medic;
import wedsan.task5.model.MedicalSpecialty;

import java.time.LocalDateTime;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
    boolean existsMedicById(long id);

    @Query("""
            select m from Medic m
            where
            m.specialty = :medicalSpecialty
            and
            m.id not in(
                select a.medic.id from MedicalAppointment a
                where
                a.date = :date
            )
            order by rand()
            limit 1
        """)
    Medic chooseRandomMedicOnDate(MedicalSpecialty medicalSpecialty, LocalDateTime date);
}
