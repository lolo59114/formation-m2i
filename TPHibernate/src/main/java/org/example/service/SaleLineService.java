package org.example.service;

import org.example.entity.SaleLine;
import org.example.repository.SaleLineRepository;

import java.util.List;

public class SaleLineService implements BaseService<SaleLine> {
    SaleLineRepository saleLineRepository;
    public SaleLineService() {
        this.saleLineRepository = new SaleLineRepository();
    }


    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public SaleLine findById(long id) {
        return null;
    }

    @Override
    public List<SaleLine> getAll() {
        return List.of();
    }


    public boolean create(SaleLine saleLine) {
        return saleLineRepository.save(saleLine);
    }
}
