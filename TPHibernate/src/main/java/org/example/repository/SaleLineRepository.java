package org.example.repository;

import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.hibernate.query.Query;

import java.util.List;

public class SaleLineRepository extends BaseRepository<SaleLine> {

    @Override
    public boolean save(SaleLine sale) {
        boolean success = false;
        try {
            openSession();
            session.beginTransaction();
            session.merge(sale.getId().getArticle());
            session.persist(sale);
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
