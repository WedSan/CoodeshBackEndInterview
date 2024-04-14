package wedsan.task5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wedsan.task5.dto.request.MedAppointmentCancellationDTOReq;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.dto.response.MedicalAppointmentDTORes;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;
import wedsan.task5.service.MedicalAppointmentService;

@RestController
@RequestMapping("medical_appointment")
public class MedicalAppointmentController {

    private MedicalAppointmentService medicalAppointmentService;

    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService) {
        this.medicalAppointmentService = medicalAppointmentService;
    }

    @PostMapping
    public ResponseEntity scheduleMedicalAppointment(@RequestBody MedicalAppointmentDTOReq medicalAppointment) {
        MedicalAppointment appointmentRegistered = medicalAppointmentService.schedule(medicalAppointment);
        return ResponseEntity.ok().body(new MedicalAppointmentDTORes(appointmentRegistered));
    }

    @DeleteMapping
    public ResponseEntity cancelMedicalAppointment(@RequestBody MedAppointmentCancellationDTOReq appointmentCancellation) {
        var medAppointmendCanceled = medicalAppointmentService.cancel(appointmentCancellation);
        return ResponseEntity.status(HttpStatus.OK).body(medAppointmendCanceled);
    }
}
