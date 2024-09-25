package org.example.tp_jee_hopital.service;

import org.example.tp_jee_hopital.model.Patient;
import org.example.tp_jee_hopital.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class PatientService {
    private PatientRepository patientRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public PatientService(SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
    }

    public Patient getPatient(long id) {
        Patient patient = null;
        session = _sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        try {
            patient = patientRepository.findById(Patient.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return patient;
    }

    public boolean createPatient(String firstname, String lastname, String phoneNumber, LocalDate birthdate, String pictureName) {
        boolean success = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        patientRepository = new PatientRepository(session);
        Patient patient = new Patient(firstname, lastname, phoneNumber, birthdate, pictureName);
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            success = true;
        } catch (Exception ex) {
            try{
                session.getTransaction().rollback();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }
        return success;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = null;
        session = _sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        try {
            patients = patientRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return patients;
    }
}
