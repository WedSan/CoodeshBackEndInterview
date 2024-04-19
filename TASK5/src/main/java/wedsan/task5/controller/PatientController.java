package wedsan.task5.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wedsan.task5.dto.request.patient.PatientDTOReq;
import wedsan.task5.dto.request.patient.PatientUpdateDTOReq;
import wedsan.task5.dto.response.PatientDTORes;
import wedsan.task5.model.Patient;
import wedsan.task5.service.PatientService;

/**
 * Controller class for handling patient-related endpoints.
 */
@RestController
@RequestMapping("patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    /**
     * Registers a new patient.
     *
     * @param data The patient data to be registered.
     * @return ResponseEntity containing the registered patient data.
     */
    @PostMapping
    public ResponseEntity registerPatient(@RequestBody @Valid PatientDTOReq data) {
        Patient patient = this.patientService.createPatient(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PatientDTORes(patient));
    }

    /**
     * Retrieves a page of patients.
     *
     * @param pageable Pageable object for pagination and sorting.
     * @return ResponseEntity containing a page of patient data.
     */
    @GetMapping
    public ResponseEntity<Page<PatientDTORes>> listPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<PatientDTORes> page = this.patientService.listPatients(pageable).map(PatientDTORes::new);
        return ResponseEntity.ok(page);
    }

    /**
     * Updates an existing patient.
     *
     * @param data The updated patient data.
     * @param id   The ID of the patient to be updated.
     * @return ResponseEntity containing the updated patient data.
     */
    @PatchMapping("/{id}")
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdateDTOReq data, @PathVariable Long id) {
        Patient updatedPatient = patientService.updatePatient(data, id);
        return ResponseEntity.ok(new PatientDTORes(updatedPatient));
    }

    /**
     * Deletes a patient.
     *
     * @param id The ID of the patient to be deleted.
     * @return ResponseEntity indicating the success of the deletion operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Finds a patient by ID.
     *
     * @param id The ID of the patient to be found.
     * @return ResponseEntity containing the patient data.
     */
    @GetMapping("/{id}")
    public ResponseEntity findPatientById(@PathVariable Long id) {
        Patient patient = patientService.findPatientById(id);
        return ResponseEntity.ok(new PatientDTORes(patient));
    }

}
