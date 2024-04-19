package wedsan.task5.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wedsan.task5.dto.request.medic.DoctorDTOReq;
import wedsan.task5.dto.request.medic.DoctorUpdateDTOReq;
import wedsan.task5.dto.response.DoctorDTORes;
import wedsan.task5.model.Doctor;
import wedsan.task5.service.DoctorService;


@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * Register a new doctor.
     *
     * @param data The doctor data to be registered.
     * @return ResponseEntity containing the registered doctor data.
     */
    @PostMapping
    public ResponseEntity registerDoctor(@RequestBody @Valid DoctorDTOReq data) {
        Doctor doctor = doctorService.createDoctor(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    /**
     * Get a list of doctors.
     *
     * @param pageable The pageable information for pagination.
     * @return ResponseEntity containing a page of doctor data.
     */
    @GetMapping
    public ResponseEntity listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<DoctorDTORes> doctors = doctorService.listDoctors(pageable).map(DoctorDTORes::new);
        return ResponseEntity.ok(doctors);
    }

    /**
     * Update an existing doctor.
     *
     * @param data The updated doctor data.
     * @param id   The ID of the doctor to be updated.
     * @return ResponseEntity containing the updated doctor data.
     */
    @PatchMapping("/{id}")
    public ResponseEntity updateDoctor(@RequestBody @Valid DoctorUpdateDTOReq data, @PathVariable Long id) {
        Doctor doctor = doctorService.udpateDoctor(data, id);
        return ResponseEntity.ok(doctor);
    }

    /**
     * Delete a doctor by ID.
     *
     * @param id The ID of the doctor to be deleted.
     * @return ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Find a doctor by ID.
     *
     * @param id The ID of the doctor to be found.
     * @return ResponseEntity containing the doctor data.
     */
    @GetMapping("/{id}")
    public ResponseEntity findDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        return ResponseEntity.ok(new DoctorDTORes(doctor));
    }
}
