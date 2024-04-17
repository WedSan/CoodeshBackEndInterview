package wedsan.task5.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.MedAppointmentCancellationDTOReq;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Medic;
import wedsan.task5.model.Patient;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;
import wedsan.task5.model.medicalAppointment.MedicalAppointmentCanceled;
import wedsan.task5.model.medicalAppointment.validators.MedicalAppointmentValidators;
import wedsan.task5.repository.MedicRepository;
import wedsan.task5.repository.MedicalAppointmentCanceledRepository;
import wedsan.task5.repository.MedicalAppointmentRepository;
import wedsan.task5.repository.PatientRepository;

import java.util.List;
@Service
public class MedicalAppointmentService {

    private PatientRepository patientRepository;

    private MedicRepository medicRepository;

    private MedicalAppointmentRepository medicalAppointmentRepository;

    private MedicalAppointmentCanceledRepository medicalAppointmentCanceledRepository;

    private List<MedicalAppointmentValidators> validatorsList;

    public MedicalAppointmentService(PatientRepository patientRepository, MedicRepository medicRepository, MedicalAppointmentRepository medicalAppointmentRepository, MedicalAppointmentCanceledRepository medicalAppointmentCanceledRepository, List<MedicalAppointmentValidators> validatorsList) {
        this.patientRepository = patientRepository;
        this.medicRepository = medicRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.medicalAppointmentCanceledRepository = medicalAppointmentCanceledRepository;
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
            throw new ValidationException("There is no doctor available on this date!");
        }

        MedicalAppointment appointment = new MedicalAppointment(null, medic, patient, dataReq.date());
        medicalAppointmentRepository.save(appointment);

        return appointment;

    }
    @Transactional
    public MedicalAppointmentCanceled cancel(MedAppointmentCancellationDTOReq appointCancellation, Long id) {
        if(!medicalAppointmentRepository.existsById(id)){
            throw new EntityNotFoundException("Medical Appointment id doesn't exist!");
        }

        var medicalAppointment = this.medicalAppointmentRepository.getReferenceById(id);
        this.medicalAppointmentRepository.delete(medicalAppointment);

        System.out.println("Não deu erro aqui 1");
        MedicalAppointmentCanceled medAppointmentCanceled = new MedicalAppointmentCanceled(medicalAppointment,
                appointCancellation.cancellationReason());


        System.out.println("Não deu erro aqui 2");
        return this.medicalAppointmentCanceledRepository.save(medAppointmentCanceled);
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
