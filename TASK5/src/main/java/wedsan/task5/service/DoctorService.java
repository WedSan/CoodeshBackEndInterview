package wedsan.task5.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.medic.DoctorDTOReq;
import wedsan.task5.dto.request.medic.DoctorUpdateDTOReq;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.userEntity.validators.creation.UserEntityCreationValidator;
import wedsan.task5.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    private List<UserEntityCreationValidator> creationValidatorList;

    private DoctorRepository repository;

    public DoctorService(List<UserEntityCreationValidator> creationValidatorList, DoctorRepository doctorRepository) {
        this.creationValidatorList = creationValidatorList;
        this.repository = doctorRepository;
    }

    @Transactional
    public Doctor createDoctor(DoctorDTOReq data) {
        Doctor doctor = new Doctor(data);

        creationValidatorList.forEach(v -> v.validate(doctor));

        repository.save(doctor);

        return doctor;
    }


    public Page<Doctor> listDoctors(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Doctor udpateDoctor(DoctorUpdateDTOReq data, Long id) {
        Doctor doctor = repository.getReferenceById(id);

        if (data.name() != null) {
            doctor.setName(data.name());
        }
        if (data.phone() != null) {
            doctor.setPhone(data.phone());
        }
        if (data.address() != null) {
            doctor.getAddress().updateAddress(data.address());
        }

        return repository.save(doctor);
    }

    @Transactional
    public void deleteDoctor(Long id) {
        Doctor doctor = repository.getReferenceById(id);
        repository.delete(doctor);
    }

    public Doctor findDoctorById(Long id) {
        return repository.getReferenceById(id);
    }

}
