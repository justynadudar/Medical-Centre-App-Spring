package com.example.task.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    private Long id;

    @NotNull
    @Size(min = 2, message = "FirstName should be at least 2 chars")
    private String name;

    @NotNull
    @Size(min = 2, message = "FirstName should be at least 2 chars")
    private String surname;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phone_number;

    @NotNull
    @Past(message = "Date of birth should be less than today.")
    private Date date_of_birth;

    public Person(Long id, String name, String surname, String email, String phone_number, Date date_of_birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
    }

    public Person(String name, String surname, String email, String phone_number, Date date_of_birth) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
    }

    public Person() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

}
