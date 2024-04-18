package wedsan.task5.model.medicalAppointment.validators;

import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.repository.MedicalAppointmentRepository;

public class MedicAlreadyBusyOnTheDayValidator implements MedicalAppointmentValidators {

    private MedicalAppointmentRepository repository;

    @Override
    public void validate(MedicalAppointmentDTOReq req) {
        boolean exists = repository.existsMedicalAppointmentByMedicIdAndDate(req.idMedic(), req.date());
        if(exists){
            throw new ValidationException("The medic is already busy on the day");
        }
    }
}
