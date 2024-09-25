package org.example.tp_jee_hopital.repository;

import org.example.tp_jee_hopital.model.Consultation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationRepository extends BaseRepository<Consultation> {

    public ConsultationRepository(Session session) {
        super(session);
    }

    @Override
    public List<Consultation> findAll() {
        Query<Consultation> query = _session.createQuery("from Consultation", Consultation.class);
        return query.list();
    }

    public List<Consultation> findAllByPatient(long idPatient) {
        Query<Consultation> query = _session.createQuery("from Consultation p where p.patient.idPatient = :idPatient", Consultation.class);
        query.setParameter("idPatient", idPatient);
        return query.list();
    }

}
