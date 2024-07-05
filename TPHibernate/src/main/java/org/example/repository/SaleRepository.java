package org.example.repository;

import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class SaleRepository extends BaseRepository<Sale>{
    public SaleRepository() {
        super();
    }

    public List<Sale> getAll (){
        openSession();
        Query<Sale> query = session.createQuery("from Sale", Sale.class);
        return query.list();
    }


    @Override
    public Sale getById (Class<Sale> classe, long id) {
        openSession();
        Query<Sale> query = session.createQuery("from Sale s join fetch s.saleLines where s.id = :idSale", Sale.class);
        query.setParameter("idSale", id);
        Sale sale = query.getSingleResult();
        session.close();
        return sale;
    }

    public List<Sale> getSalesByIdArticle(long id) {
        openSession();
        Query<Sale> query = session.createQuery("from Sale s where s.id in (select sl.id.sale.id from SaleLine sl where sl.id.article.id = :id)", Sale.class)
                .setParameter("id", id);
        List<Sale> sales = query.list();
        session.close();
        return sales;
    }

    public List<Sale> getSalesBySaleDate(LocalDate period) {
        openSession();
        Query<Sale> query = session.createQuery("from Sale s where s.saleDate = :saleDate", Sale.class)
                .setParameter("saleDate", period);
        List<Sale> sales = query.list();
        session.close();
        return sales;
    }
}
