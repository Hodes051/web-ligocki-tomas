package evidence.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Table(name = "insured")
@Entity
public class InsuredEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Jméno je povinné")
    private String name;

    @NotBlank(message = "Příjmení je povinné")
    private String surname;

    @NotBlank(message = "Email je povinný")
    @Email(message = "Neplatný email")
    private String email;

    @NotBlank(message = "Telefon je povinný")
    private String phone;

    @NotBlank(message = "Město je povinné")
    private String city;

    @NotBlank(message = "Ulice je povinná")
    private String street;

    @NotBlank(message = "PSČ je povinné")
    private String postCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}