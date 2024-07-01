package org.example.repository;

import org.example.entity.Sale;
import org.hibernate.query.Query;

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
}
