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

@RestController
@RequestMapping("patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity registerPatient(@RequestBody @Valid PatientDTOReq data) {
        Patient patient = this.patientService.createPatient(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PatientDTORes(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientDTORes>> listPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
       Page<PatientDTORes> page = this.patientService.listPatients(pageable).map(PatientDTORes::new);
        return ResponseEntity.ok(page);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdateDTOReq data, @PathVariable Long id) {
        Patient udpatedPatient = patientService.updatePatient(data, id);

        return ResponseEntity.ok(new PatientDTORes(udpatedPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findPatientById(@PathVariable Long id) {
        Patient paciente = patientService.findPatientById(id);
        return ResponseEntity.ok(new PatientDTORes(paciente));
    }

}
