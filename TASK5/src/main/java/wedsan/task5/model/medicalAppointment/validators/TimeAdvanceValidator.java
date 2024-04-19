package wedsan.task5.model.medicalAppointment.validators;

import org.springframework.stereotype.Component;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Validator that checks if the medical appointment is scheduled with sufficient advance notice.
 * Throws a ValidationException if the appointment is not scheduled at least 24 hours in advance.
 */
@Component
public class TimeAdvanceValidator implements MedicalAppointmentValidators {

    /**
     * Validates the medical appointment request by checking if it is scheduled with sufficient advance notice.
     * Throws a ValidationException if the appointment is not scheduled at least 24 hours in advance.
     * @param req The medical appointment request to be validated.
     * @throws ValidationException If the appointment is not scheduled 1 day in advance.
     */
    @Override
    public void validate(MedicalAppointmentDTOReq req) {
        LocalDateTime scheduleDate = req.date();
        LocalDateTime dateNow = LocalDateTime.now();
        long differenceHours = Duration.between(dateNow, scheduleDate).toHours();

        if (differenceHours < 24) {
            throw new ValidationException("A medical appointment must be scheduled 1 day in advance");
        }
    }
}
