package wedsan.task5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    public ResponseEntity scheduleMedicalAppointment(@RequestBody MedicalAppointmentDTOReq medicalAppointment) {
        MedicalAppointment appointmentRegistered = medicalAppointmentService.schedule(medicalAppointment);
        return ResponseEntity.ok().body(new MedicalAppointmentDTORes(appointmentRegistered));
    }
}
