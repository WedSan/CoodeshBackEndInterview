package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.medicalAppointment.MedicalAppointmentCanceled;
@Repository
public interface MedicalAppointmentCanceledRepository extends JpaRepository<MedicalAppointmentCanceled, Long> {
}
