package org.example.service;

import org.example.entity.Sale;
import org.example.repository.SaleLineRepository;
import org.example.repository.SaleRepository;

import java.time.LocalDate;
import java.util.List;

public class SaleService implements BaseService<Sale>{
    SaleRepository saleRepository;
    SaleLineRepository saleLineRepository;
    public SaleService() {
        saleRepository = new SaleRepository();
        saleLineRepository = new SaleLineRepository();
    }

    @Override
    public boolean delete(long id) {
        Sale sale = saleRepository.getById(Sale.class, id);
        if(sale == null) {
            System.out.println("La vente avec id " + id + " n'a pas été trouvée");
            return false;
        } else {
            return saleRepository.delete(sale);
        }
    }

    @Override
    public Sale findById(long id) {
        Sale sale = saleRepository.getById(Sale.class, id);
        return sale;
    }


    @Override
    public List<Sale> getAll() {
        return saleRepository.getAll();
    }

    public boolean create(Sale newSale) {
        return saleRepository.save(newSale);
    }

    public boolean update(Sale sale) {
        return saleRepository.update(sale);
    }

    public List<Sale> getSalesByIdArticle(long id) {
        return saleRepository.getSalesByIdArticle(id);
    }

    public List<Sale> getSalesBySaleDate(LocalDate period) {
        return saleRepository.getSalesBySaleDate(period);
    }
}
