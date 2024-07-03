package org.example.service;

import org.example.entity.SaleLine;
import org.example.repository.SaleLineRepository;

public class SaleLineService implements BaseService<SaleLine> {
    SaleLineRepository saleLineRepository;
    public SaleLineService() {
        this.saleLineRepository = new SaleLineRepository();
    }

    @Override
    public void delete() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void displayAll() {

    }

    public boolean create(SaleLine saleLine) {
        return saleLineRepository.save(saleLine);
    }
}
