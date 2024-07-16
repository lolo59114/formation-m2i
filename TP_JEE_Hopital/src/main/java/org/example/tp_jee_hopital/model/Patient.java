package org.example.tp_jee_hopital.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-patient")
    private long idPatient;

    @Column(name = "first-name")
    private String firstName;
    @Column(name = "last-name")
    private String lastName;
    @Column(name = "phone-number")
    private String phoneNumber;
    @Column(name = "date-of-birth")
    private LocalDate dateOfBirth;
    @Column(name = "picture-name")
    private String pictureName;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Consultation> consultations;

    public Patient(String firstName, String lastName, String phoneNumber, LocalDate dateOfBirth, String pictureName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.pictureName = pictureName;
        this.consultations = new ArrayList<>();
    }

    public Patient() {
        this.consultations = new ArrayList<>();
    }

    public long getIdPatient() {
        return idPatient;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPictureName() {
        return pictureName;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", pictureName='" + pictureName + '\'' +
                '}';
    }
}
