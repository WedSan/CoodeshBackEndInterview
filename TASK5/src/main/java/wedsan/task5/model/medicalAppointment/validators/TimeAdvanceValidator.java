package wedsan.task5.model.medicalAppointment.validators;

import org.springframework.stereotype.Component;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class TimeAdvanceValidator implements MedicalAppointmentValidators {
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
