package org.example.repository;

import org.example.entity.SaleLine;

public class SaleLineRepository extends BaseRepository<SaleLine> {

    @Override
    public boolean save(SaleLine entity) {
        boolean success = false;
        try {
            openSession();
            session.beginTransaction();
            session.merge(entity.getId().getArticle());
            session.persist(entity);
            session.getTransaction().commit();
            success = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return success;
    }
}
