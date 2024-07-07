package org.example.repository;

import org.example.entity.Sale;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SaleRepository extends BaseRepository<Sale>{
    public SaleRepository() {
        super();
    }

    public List<Sale> getAll (){
        openSession();
        Query<Sale> query = session.createQuery("from Sale", Sale.class);
        List<Sale> sales = query.list();
        session.close();
        return sales;
    }

    @Override
    public Sale getById (Class<Sale> classe, long id) {
        openSession();
        Query<Sale> query = session.createQuery("select distinct s from Sale s left join fetch s.saleLines where s.id = :idSale", classe);
        query.setParameter("idSale", id);
        Optional<Sale> sale = query.uniqueResultOptional();
        session.close();
        return sale.orElse(null);
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
