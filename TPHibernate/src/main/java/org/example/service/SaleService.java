package org.example.service;

import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.example.repository.SaleLineRepository;
import org.example.repository.SaleRepository;
import org.example.util.InputManager;

import java.util.List;

public class SaleService implements BaseService<Sale>{
    SaleRepository saleRepository;
    SaleLineRepository saleLineRepository;
    public SaleService() {
        saleRepository = new SaleRepository();
        saleLineRepository = new SaleLineRepository();
    }

    @Override
    public void delete() {
        System.out.println("=== Suppression d'une vente ===");
        long id = InputManager.askInput("Id de la vente à supprimer:", Long.class);
        Sale sale = saleRepository.getById(Sale.class, id);
        if(sale == null) {
            System.out.println("La vente avec id " + id + " n'a pas été trouvée");
        } else {
            saleRepository.delete(sale);
        }
    }

    public Sale getById(long id) {
        Sale sale = saleRepository.getById(Sale.class, id);
        if(sale != null) {
            sale.setSaleLines(saleLineRepository.getAllByIdSale(sale.getIdSale()));
        }
        return sale;
    }

    @Override
    public void findById() {
        System.out.println("=== Affichage d'une vente ===");
        long id = InputManager.askInput("Id de la vente à afficher:", Long.class);
        Sale sale = saleRepository.getById(Sale.class, id);
        if(sale == null) {
            System.out.println("La vente avec id " + id + " n'a pas été trouvée");
        } else {
            List<SaleLine> saleLines = saleLineRepository.getAllByIdSale(id);
            System.out.println(sale);
            for(SaleLine saleLine : saleLines) {
                System.out.println(saleLine);
            }
        }
    }

    @Override
    public void displayAll() {
        List<Sale> sales = saleRepository.getAll();
        for(Sale sale : sales) {
            System.out.println(sale);
        }
    }

    public boolean create(Sale newSale) {
        return saleRepository.save(newSale);
    }

    public boolean update(Sale sale) {
        return saleRepository.update(sale);
    }
}
