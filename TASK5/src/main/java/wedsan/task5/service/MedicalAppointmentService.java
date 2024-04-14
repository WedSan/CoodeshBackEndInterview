package wedsan.task5.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Medic;
import wedsan.task5.model.Patient;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;
import wedsan.task5.model.medicalAppointment.validators.MedicalAppointmentValidators;
import wedsan.task5.repository.MedicRepository;
import wedsan.task5.repository.MedicalAppointmentRepository;
import wedsan.task5.repository.PatientRepository;

import java.util.List;
@Service
public class MedicalAppointmentService {

    private PatientRepository patientRepository;

    private MedicRepository medicRepository;

    private MedicalAppointmentRepository medicalAppointmentRepository;

    private List<MedicalAppointmentValidators> validatorsList;

    public MedicalAppointmentService(MedicalAppointmentRepository repository, PatientRepository patientRepository, MedicRepository medicRepository, MedicalAppointmentRepository medicalAppointmentRepository, List<MedicalAppointmentValidators> validatorsList) {
        this.patientRepository = patientRepository;
        this.medicRepository = medicRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.validatorsList = validatorsList;
    }
    @Transactional
    public MedicalAppointment schedule(MedicalAppointmentDTOReq dataReq) {
        if(!patientRepository.existsPatientById(dataReq.idPatient())){
            throw new EntityNotFoundException("Pacient id doesn't exist!");
        }
        if(dataReq.idMedic() != null && !medicRepository.existsMedicById(dataReq.idMedic())){
            throw new EntityNotFoundException("Medic id doesn't exist!");
        }

        validatorsList.forEach(v -> v.validate(dataReq));

        Patient patient = patientRepository.getReferenceById(dataReq.idPatient());
        Medic medic = chooseMedic(dataReq);
        if (medic == null) {
            throw new ValidationException("Não existe médico disponível nessa data!");
        }

        MedicalAppointment appointment = new MedicalAppointment(null, medic, patient, dataReq.date());
        medicalAppointmentRepository.save(appointment);

        return appointment;

    }

    private Medic chooseMedic(MedicalAppointmentDTOReq data) {
        if (data.idMedic() != null) {
            return medicRepository.getReferenceById(data.idMedic());
        }

        if (data.medicalSpecialty() == null) {
            throw new ValidationException("pecialty is mandatory when no doctor is chosen!");
        }

        return medicRepository.chooseRandomMedicOnDate(data.medicalSpecialty(), data.date());
    }
}
