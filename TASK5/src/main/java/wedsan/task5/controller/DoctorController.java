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
    private DoctorService medicoService;

    @PostMapping
    public ResponseEntity registerDoctor(@RequestBody @Valid DoctorDTOReq data) {
        Doctor doctor = medicoService.createDoctor(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    @GetMapping
    public ResponseEntity listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<DoctorDTORes> doctors = medicoService.listDoctors(pageable).map(DoctorDTORes::new);
        return ResponseEntity.ok(doctors);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateDoctor(@RequestBody @Valid DoctorUpdateDTOReq data, @PathVariable Long id) {
        Doctor doctor = medicoService.udpateDoctor(data, id);
        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        medicoService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findDoctorById(@PathVariable Long id) {
        Doctor doctor = medicoService.findDoctorById(id);
        return ResponseEntity.ok(new DoctorDTORes(doctor));
    }
}
