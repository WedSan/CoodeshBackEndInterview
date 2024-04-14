package wedsan.task5.dto.request;

public record MedAppointmentCancellationDTOReq(
        Long idMedicalAppointment,
        String cancellationReason
) {

}
