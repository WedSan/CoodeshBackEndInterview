package wedsan.task5.model.medicalAppointment.validators;

import org.springframework.stereotype.Component;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;

import java.time.DayOfWeek;

@Component
public class DayOperationValidator implements MedicalAppointmentValidators {
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
