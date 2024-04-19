package wedsan.task5.model.medicalAppointment.validators;

import wedsan.task5.dto.request.MedicalAppointmentDTOReq;

/**
 * Interface for validating medical appointment requests.
 * Implementations of this interface perform specific validation checks on medical appointment data.
 */
public interface MedicalAppointmentValidators {
    /**
     * Validates the medical appointment request.
     * @param req The medical appointment request to be validated.
     */
    void validate(MedicalAppointmentDTOReq req);
}
