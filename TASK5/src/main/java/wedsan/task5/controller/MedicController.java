package wedsan.task5.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wedsan.task5.dto.request.medic.MedicDTOReq;
import wedsan.task5.dto.request.medic.MedicUpdateDTOReq;
import wedsan.task5.dto.response.MedicDTORes;
import wedsan.task5.model.Medic;
import wedsan.task5.service.MedicService;


@RestController
@RequestMapping("medics")
public class MedicController {
    @Autowired
    private MedicService medicoService;

    @PostMapping
    public ResponseEntity registerMedic(@RequestBody @Valid MedicDTOReq data) {
        Medic medic = medicoService.createMedic(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(medic);
    }

    @GetMapping
    public ResponseEntity listsMedics(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<MedicDTORes> medics = medicoService.listMedics(pageable).map(MedicDTORes::new);
        return ResponseEntity.ok(medics);
    }

    @PutMapping
    public ResponseEntity updateMedic(@RequestBody @Valid MedicUpdateDTOReq data) {
        Medic medic = medicoService.updateMedic(data) ;
        return ResponseEntity.ok(medic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMedic(@PathVariable Long id) {
        medicoService.deleteMedic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findMedicoById(@PathVariable Long id) {
        Medic medico = medicoService.findMedicById(id);
        return ResponseEntity.ok(new MedicDTORes(medico));
    }
}
