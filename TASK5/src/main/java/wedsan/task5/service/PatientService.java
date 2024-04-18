package wedsan.task5.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.patient.PatientDTOReq;
import wedsan.task5.dto.request.patient.PatientUpdateDTOReq;
import wedsan.task5.model.Patient;
import wedsan.task5.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Patient createPatient(PatientDTOReq data) {
        Patient patient = new Patient(data);
        repository.save(patient);

        return patient;
    }

    public Page<Patient> listPatients(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Patient updatePatient(PatientUpdateDTOReq data) {
        Patient patient = repository.getReferenceById(data.id());

        if (data.name() != null) {
            patient.setName(data.name());
        }
        if (data.phone() != null) {
            patient.setPhone(data.phone());
        }
        if (data.address() != null) {
            patient.getAddress().updateAddress(data.address());
        }

        return repository.save(patient);
    }

    @Transactional
    public void deletePatient(Long id) {
        Patient patient  = repository.getReferenceById(id);
        repository.delete(patient);
    }

    public Patient findPatientById( Long id) {
        return repository.getReferenceById(id);
    }

}
