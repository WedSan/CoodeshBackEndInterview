package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
}
