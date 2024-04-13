package wedsan.task5.dto.response;

import wedsan.task5.model.Address;
import wedsan.task5.model.Medic;
import wedsan.task5.model.MedicalSpecialty;

public record MedicDTORes (
        Long id,
        String nome,
        String email,
        String medicalDocument,
        String phone,
        MedicalSpecialty especialidade,
        Address endereco
){
    public MedicDTORes(Medic medic) {
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getMedicDocument(), medic.getPhone(),medic.getSpecialty(), medic.getAddress());
    }
}
