package org.example.tp_jee_hopital.repository;

import org.example.tp_jee_hopital.model.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PatientRepository extends BaseRepository<Patient> {

    public PatientRepository(Session session) {
        super(session);
    }

    @Override
    public List<Patient> findAll() {
        Query<Patient> query = _session.createQuery("from Patient", Patient.class);
        return query.list();
    }
}
