package wedsan.task5.model.medicalAppointment.validators;

import org.springframework.stereotype.Component;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;

import java.time.DayOfWeek;

/**
 * Validator that checks if the medical appointment is scheduled within the clinic's operating hours.
 * Throws a ValidationException if the appointment is scheduled on Sunday or outside the clinic's opening hours.
 */
@Component
public class DayOperationValidator implements MedicalAppointmentValidators {

    /**
     * Validates the medical appointment request by checking if it is scheduled within the clinic's operating hours.
     * Throws a ValidationException if the appointment is scheduled on Sunday or outside the clinic's opening hours.
     * @param appointmentData The medical appointment request to be validated.
     * @throws ValidationException If the appointment is scheduled outside clinic operating hours.
     */
    @Override
    public void validate(MedicalAppointmentDTOReq appointmentData) {
        var appointmentDate = appointmentData.date();

        var isSunday = appointmentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isBeforeClinicOpening = appointmentDate.getHour() < 7;
        var isAfterClinicClosing = appointmentDate.getHour() > 18;
        if (isSunday || isBeforeClinicOpening || isAfterClinicClosing) {
            throw new ValidationException("Appointment outside clinic operating hours");
        }
    }
}
