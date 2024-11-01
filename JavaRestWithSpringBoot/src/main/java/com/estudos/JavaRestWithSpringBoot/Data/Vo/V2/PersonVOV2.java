package com.estudos.JavaRestWithSpringBoot.Data.Vo.V2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@JsonPropertyOrder({"id", "firstName", "lastName", "adress", "gender", "birthDay"})
public class PersonVOV2 implements Serializable {

    @Serial
    private static  final long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long id;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("BirthDay")
    private Date birthDay;

    public PersonVOV2() {}

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

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() { return birthDay; }
    public void setBirthDay(Date birthDay) { this.birthDay = birthDay; }
}
