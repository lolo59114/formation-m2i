package org.example.repository;

import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.hibernate.query.Query;

import java.util.List;

public class SaleLineRepository extends BaseRepository<SaleLine> {

    public List<SaleLine> getAllByIdSale(long id) {
        openSession();
        Query<SaleLine> query = session.createQuery("from SaleLine sl where sl.id.sale.id = :idSale", SaleLine.class)
                .setParameter("idSale", id);
        return query.list();
    }

    public List<SaleLine> getAllByIdArticle(long id) {
        openSession();
        Query<SaleLine> query = session.createQuery("from SaleLine sl where sl.id.article.id = :idArticle", SaleLine.class)
                .setParameter("idArticle", id);
        return query.list();
    }

    @Override
    public boolean save(SaleLine sale) {
        try {
            openSession();
            session.beginTransaction();
            session.merge(sale.getId().getArticle());
            session.persist(sale);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }
}
