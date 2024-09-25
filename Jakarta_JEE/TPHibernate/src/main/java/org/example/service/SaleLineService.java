package org.example.service;

import org.example.entity.SaleLine;
import org.example.repository.SaleLineRepository;

import java.util.List;

public class SaleLineService {
    SaleLineRepository saleLineRepository;
    public SaleLineService() {
        this.saleLineRepository = new SaleLineRepository();
    }

    public boolean create(SaleLine saleLine) {
        return saleLineRepository.save(saleLine);
    }
}
