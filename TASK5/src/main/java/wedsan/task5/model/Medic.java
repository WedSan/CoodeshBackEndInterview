package wedsan.task5.model;

import jakarta.persistence.*;
import wedsan.task5.dto.request.MedicDTOReq;

@Entity
@Table(name = "TB_MEDIC")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;

    private String phone;

    private String medicDocument;

    @Enumerated(EnumType.STRING)
    private MedicalSpecialty specialty;

    @Embedded
    private Address address;

    public Medic(MedicDTOReq medic){
        this.name = medic.name();
        this.email = medic.email();
        this.phone = medic.phone();
        this.medicDocument = medic.medicDocument();
        this.specialty = medic.specialty();
        this.address = new Address(medic.address());
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
