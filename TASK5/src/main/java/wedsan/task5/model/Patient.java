package wedsan.task5.model;

import jakarta.persistence.*;
import wedsan.task5.dto.request.patient.PatientDTOReq;
import wedsan.task5.model.userEntity.UserEntity;
/**
 * Represents a patient entity in the system.
 */
@Entity
@Table(name = "TB_PATIENT")
public class Patient extends UserEntity {

    private String document;

    public Patient(){}

    public Patient(PatientDTOReq patient){
        super(null, patient.name(), patient.email(), patient.phone(), new Address(patient.address()));
        this.setDocument(patient.document());
    }

    public Patient(Long id, String name, String email, String phone, Address address, String document) {
        super(id, name, email, phone, address);
        this.setDocument(document);
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        // Remove non-numeric characters from the document
        this.document = document.replaceAll("[^0-9]", "");;
    }
}
