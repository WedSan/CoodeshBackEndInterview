package wedsan.task5.model.medicalAppointment.validators;

import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.repository.MedicalAppointmentRepository;

import java.time.LocalDateTime;

public class PatientWithoutAnotherAppointmentValidator implements MedicalAppointmentValidators {

    private MedicalAppointmentRepository repository;

    @Override
    public void validate(MedicalAppointmentDTOReq req) {
        LocalDateTime firstTime = req.date().withHour(7);
        LocalDateTime lastTime = req.date().withHour(18);
        boolean existsAppointmentOnTheDay = repository.existsByPatientIdAndDateBetween(req.idPatient(), firstTime, lastTime);
        if (existsAppointmentOnTheDay) {
            throw new ValidationException("The patient already has an appointment scheduled that day");
        }
    }
}
