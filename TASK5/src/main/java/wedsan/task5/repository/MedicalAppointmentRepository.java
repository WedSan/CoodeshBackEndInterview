package wedsan.task5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;

import java.time.LocalDateTime;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
    boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario,
                                             LocalDateTime ultimoHorario);
}
