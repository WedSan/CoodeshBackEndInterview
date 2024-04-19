package wedsan.task5.model.medicalAppointment.validators;

import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.repository.MedicalAppointmentRepository;

import java.time.LocalDateTime;

/**
 * Validator that checks if the patient already has another appointment scheduled on the same day.
 * Throws a ValidationException if such an appointment exists.
 */
public class PatientWithoutAnotherAppointmentValidator implements MedicalAppointmentValidators {

    private MedicalAppointmentRepository repository;

    /**
     * Validates the medical appointment request by checking if the patient has another appointment scheduled on the same day.
     * Throws a ValidationException if such an appointment exists.
     * @param req The medical appointment request to be validated.
     * @throws ValidationException If the patient already has an appointment scheduled that day.
     */
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
