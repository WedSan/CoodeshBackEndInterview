package wedsan.task5.model.medicalAppointment.validators;

import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.repository.MedicalAppointmentRepository;
/**
 * Validator that checks if the doctor is already busy on the specified day.
 * Throws a ValidationException if the doctor has another appointment scheduled on the same day.
 */
public class DoctorAlreadyBusyOnTheDayValidator implements MedicalAppointmentValidators {

    private MedicalAppointmentRepository repository;

    /**
     * Validates the medical appointment request by checking if the doctor is already busy on the specified day.
     * Throws a ValidationException if the doctor has another appointment scheduled on the same day.
     * @param req The medical appointment request to be validated.
     * @throws ValidationException If the doctor is already busy on the day.
     */
    @Override
    public void validate(MedicalAppointmentDTOReq req) {
        boolean exists = repository.existsMedicalAppointmentByDoctorIdAndDate(req.idDoctor(), req.date());
        if(exists){
            throw new ValidationException("The medic is already busy on the day");
        }
    }
}
