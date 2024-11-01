package com.estudos.JavaRestWithSpringBoot.Data.Vo.V1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;

@JsonPropertyOrder({"id", "firstName", "lastName", "adress", "gender"})
public class PersonVO implements Serializable {

    @Serial
    private static  final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Address")
    private String adress;

    @JsonProperty("Gender")
    private String gender;

    public PersonVO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
