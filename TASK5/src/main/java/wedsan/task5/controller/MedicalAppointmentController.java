package wedsan.task5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wedsan.task5.dto.request.MedAppointmentCancellationDTOReq;
import wedsan.task5.dto.request.MedicalAppointmentDTOReq;
import wedsan.task5.dto.response.MedicalAppointmentDTORes;
import wedsan.task5.model.medicalAppointment.MedicalAppointment;
import wedsan.task5.model.medicalAppointment.MedicalAppointmentCanceled;
import wedsan.task5.service.MedicalAppointmentService;

/**
 * Controller class for managing medical appointments.
 */
@RestController
@RequestMapping("medical_appointment")
public class MedicalAppointmentController {

    private MedicalAppointmentService medicalAppointmentService;

    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService) {
        this.medicalAppointmentService = medicalAppointmentService;
    }

    /**
     * Schedule a medical appointment.
     *
     * @param medicalAppointment The medical appointment data to be scheduled.
     * @return ResponseEntity containing the scheduled medical appointment data.
     */
    @PostMapping
    public ResponseEntity scheduleMedicalAppointment(@RequestBody MedicalAppointmentDTOReq medicalAppointment) {
        MedicalAppointment appointmentRegistered = medicalAppointmentService.schedule(medicalAppointment);
        return ResponseEntity.ok().body(new MedicalAppointmentDTORes(appointmentRegistered));
    }

    /**
     * Cancel a medical appointment.
     *
     * @param appointmentCancellation The cancellation data for the medical appointment.
     * @param id                       The ID of the medical appointment to be canceled.
     * @return ResponseEntity containing the canceled medical appointment data.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity cancelMedicalAppointment(@RequestBody MedAppointmentCancellationDTOReq appointmentCancellation, @PathVariable long id) {
        MedicalAppointmentCanceled medicalAppointmentCanceled = medicalAppointmentService.cancel(appointmentCancellation, id);
        return ResponseEntity.status(HttpStatus.OK).body(medicalAppointmentCanceled);
    }
}
