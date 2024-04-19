package wedsan.task5.service;

import jakarta.persistence.EntityNotFoundException;
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
import java.util.Optional;

/**
 * Service class responsible for managing operations related to doctors.
 */
@Service
public class DoctorService {

    private List<UserEntityCreationValidator> creationValidatorList;

    private DoctorRepository repository;

    public DoctorService(List<UserEntityCreationValidator> creationValidatorList, DoctorRepository doctorRepository) {
        this.creationValidatorList = creationValidatorList;
        this.repository = doctorRepository;
    }

    /**
     * Creates a new doctor based on the provided data.
     * @param data The data of the doctor to be created.
     * @return The created doctor.
     */
    @Transactional
    public Doctor createDoctor(DoctorDTOReq data) {
        Doctor doctor = new Doctor(data);

        creationValidatorList.forEach(v -> v.validate(doctor));

        repository.save(doctor);

        return doctor;
    }

    /**
     * Retrieves a page of doctors.
     * @param pageable The pagination information.
     * @return A page of doctors.
     */
    public Page<Doctor> listDoctors(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Updates an existing doctor with the specified data.
     * @param data The updated data of the doctor.
     * @param id The ID of the doctor to be updated.
     * @return The updated doctor.
     */
    @Transactional
    public Doctor udpateDoctor(DoctorUpdateDTOReq data, Long id) {
        Doctor doctor = findDoctorById(id);

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

    /**
     * Deletes the doctor with the specified ID.
     * @param id The ID of the doctor to be deleted.
     */
    @Transactional
    public void deleteDoctor(Long id) {
        Doctor doctor = findDoctorById(id);
        repository.delete(doctor);
    }

    /**
     * Retrieves a doctor by ID.
     * @param id The ID of the doctor to retrieve.
     * @return The doctor with the specified ID.
     * @throws EntityNotFoundException If no doctor is found with the specified ID.
     */
    public Doctor findDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = repository.getDoctorById(id);
        if(optionalDoctor.isPresent()) {
            return optionalDoctor.get();
        }else{
            throw new EntityNotFoundException("Doctor not found, id: " + id);
        }
    }

}
