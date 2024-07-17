package org.example.tp_jee_hopital.service;

import org.example.tp_jee_hopital.model.Consultation;
import org.example.tp_jee_hopital.model.Patient;
import org.example.tp_jee_hopital.repository.ConsultationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ConsultationService {
    private ConsultationRepository consultationRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public ConsultationService(SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
    }

    public Consultation getConsultation(long id) {
        Consultation consultation = null;
        session = _sessionFactory.openSession();
        consultationRepository = new ConsultationRepository(session);
        try {
            consultation = consultationRepository.findById(Consultation.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return consultation;
    }

    public Consultation createEmptyConsultation(Patient patient) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        consultationRepository = new ConsultationRepository(session);
        Consultation consultation = new Consultation(patient);
        try {
            consultationRepository.create(consultation);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            try{
                session.getTransaction().rollback();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }
        return consultation;
    }

    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = null;
        session = _sessionFactory.openSession();
        consultationRepository = new ConsultationRepository(session);
        try {
            consultations = consultationRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return consultations;
    }

    public List<Consultation> getConsultationsByPatientId(long id) {
        List<Consultation> consultations = null;
        session = _sessionFactory.openSession();
        consultationRepository = new ConsultationRepository(session);
        try {
            consultations = consultationRepository.findAllByPatient(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return consultations;
    }

    public void updateConsultation(Consultation consultation) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        consultationRepository = new ConsultationRepository(session);
        try {
            consultationRepository.update(consultation);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            try{
                session.getTransaction().rollback();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }
    }
}
