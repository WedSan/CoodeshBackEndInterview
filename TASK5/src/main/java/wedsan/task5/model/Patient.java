package wedsan.task5.model;

import jakarta.persistence.*;
import wedsan.task5.dto.request.patient.PatientDTOReq;

@Entity
@Table(name = "TB_PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;
    @Embedded
    private Address address;

    private String document;

    public Patient(){}

    public Patient(PatientDTOReq patient){
        this.name = patient.name();
        this.email = patient.email();
        this.phone = patient.phone();
        this.address = new Address(patient.address());
        this.setDocument(patient.document());
    }

    public Patient(Long id, String name, String email, String phone, String document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.setDocument(document);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document.replaceAll("[^0-9]", "");;
    }
}
