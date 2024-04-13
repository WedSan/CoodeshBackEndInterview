package wedsan.task5.model;

import jakarta.persistence.*;
import wedsan.task5.dto.request.medic.MedicDTOReq;

@Entity
@Table(name = "TB_MEDIC")
public class Medic extends UserEntity {

    private String medicDocument;

    @Enumerated(EnumType.STRING)
    private MedicalSpecialty specialty;

    public Medic() {
    }

    public Medic(MedicDTOReq medic){
        super(null, medic.name(), medic.email(), medic.phone(), new Address(medic.address()));
        this.medicDocument = medic.medicDocument();
        this.specialty = medic.specialty();
    }

    public String getMedicDocument() {
        return medicDocument;
    }

    public void setMedicDocument(String medicDocument) {
        this.medicDocument = medicDocument;
    }

    public MedicalSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(MedicalSpecialty specialty) {
        this.specialty = specialty;
    }

}
