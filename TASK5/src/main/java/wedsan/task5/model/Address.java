package wedsan.task5.model;

import jakarta.persistence.Embeddable;
import wedsan.task5.dto.request.AddressDTORequest;

@Embeddable
public class Address {
    private String streetName;

    private String city;;

    private String state;

    private String houseNumber;

    private String zipCode;

    public Address() {}

    public Address(AddressDTORequest address){
        this.streetName = address.street();
        this.city = address.city();
        this.state = address.state();
        this.houseNumber = address.houseNumber();
        this.zipCode = address.zipCode();
    }

    public void updateAddress(AddressDTORequest address){
        this.streetName = address.street();
        this.city = address.city();
        this.state = address.state();
        this.houseNumber = address.houseNumber();
        this.zipCode = address.zipCode();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
