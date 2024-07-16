package org.example.tp_jee_hopital.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-consultation")
    private long idConsultation;

    @Column(name = "create-date")
    private LocalDate createDate;
    @Column(name = "care-sheet")
    private String careSheet;
    private String prescription;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-patient")
    private Patient patient;

    public Consultation(LocalDate createDate, String careSheet, String prescription, Patient patient) {
        this.createDate = createDate;
        this.careSheet = careSheet;
        this.prescription = prescription;
        this.patient = patient;
    }

    public Consultation(Patient patient) {
        this.createDate = LocalDate.now();
        this.patient = patient;
    }

    public Consultation() {
        this.createDate = LocalDate.now();
    }

    public long getIdConsultation() {
        return idConsultation;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public String getCareSheet() {
        return careSheet;
    }

    public String getPrescription() {
        return prescription;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", createDate=" + createDate +
                ", careSheet='" + careSheet + '\'' +
                ", prescription='" + prescription + '\'' +
                ", patient=" + patient.getIdPatient() +
                '}';
    }
}
