package wedsan.task5.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.MedAppointmentCancellationDTOReq;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.Patient;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;
import wedsan.task5.model.medicalAppointment.MedicalAppointmentCanceled;
import wedsan.task5.model.medicalAppointment.validators.MedicalAppointmentValidators;
import wedsan.task5.repository.DoctorRepository;
import wedsan.task5.repository.MedicalAppointmentCanceledRepository;
import wedsan.task5.repository.MedicalAppointmentRepository;
import wedsan.task5.repository.PatientRepository;
import java.util.List;

/**
 * Service class responsible for managing medical appointments.
 */
@Service
public class MedicalAppointmentService {

    private PatientRepository patientRepository;

    private DoctorRepository doctorRepository;

    private MedicalAppointmentRepository medicalAppointmentRepository;

    private MedicalAppointmentCanceledRepository medicalAppointmentCanceledRepository;

    private List<MedicalAppointmentValidators> validatorsList;

    public MedicalAppointmentService(PatientRepository patientRepository, DoctorRepository doctorRepository, MedicalAppointmentRepository medicalAppointmentRepository, MedicalAppointmentCanceledRepository medicalAppointmentCanceledRepository, List<MedicalAppointmentValidators> validatorsList) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.medicalAppointmentCanceledRepository = medicalAppointmentCanceledRepository;
        this.validatorsList = validatorsList;
    }

    /**
     * Schedules a new medical appointment based on the provided data.
     * @param dataReq The data of the medical appointment to be scheduled.
     * @return The scheduled medical appointment.
     */
    @Transactional
    public MedicalAppointment schedule(MedicalAppointmentDTOReq dataReq) {
        if(!patientRepository.existsPatientById(dataReq.idPatient())){
            throw new EntityNotFoundException("Patient ID does not exist!");
        }
        if(dataReq.idDoctor() != null && !doctorRepository.existsDoctorById(dataReq.idDoctor())){
            throw new EntityNotFoundException("Doctor ID does not exist!");
        }

        validatorsList.forEach(v -> v.validate(dataReq));

        Patient patient = patientRepository.getReferenceById(dataReq.idPatient());
        Doctor doctor = chooseDoctor(dataReq);
        if (doctor == null) {
            throw new ValidationException("There is no available doctor on this date!");
        }

        MedicalAppointment appointment = new MedicalAppointment(null, doctor, patient, dataReq.date());
        medicalAppointmentRepository.save(appointment);

        return appointment;
    }

    /**
     * Cancels a medical appointment with the specified ID.
     * @param appointCancellation The cancellation request data.
     * @param id The ID of the medical appointment to be canceled.
     * @return The canceled medical appointment.
     */
    @Transactional
    public MedicalAppointmentCanceled cancel(MedAppointmentCancellationDTOReq appointCancellation, Long id) {
        if(!medicalAppointmentRepository.existsById(id)){
            throw new EntityNotFoundException("Medical Appointment ID does not exist!");
        }

        var medicalAppointment = this.medicalAppointmentRepository.getReferenceById(id);
        this.medicalAppointmentRepository.delete(medicalAppointment);

        MedicalAppointmentCanceled medAppointmentCanceled = new MedicalAppointmentCanceled(medicalAppointment,
                appointCancellation.cancellationReason());

        return this.medicalAppointmentCanceledRepository.save(medAppointmentCanceled);
    }

    /**
     * Chooses a doctor for the medical appointment based on the provided data.
     * @param data The data of the medical appointment.
     * @return The chosen doctor.
     */
    private Doctor chooseDoctor(MedicalAppointmentDTOReq data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }

        if (data.medicalSpecialty() == null) {
            throw new ValidationException("Specialty is mandatory when no doctor is chosen!");
        }

        return doctorRepository.chooseRandomDoctorOnDate(data.medicalSpecialty(), data.date());
    }
}
