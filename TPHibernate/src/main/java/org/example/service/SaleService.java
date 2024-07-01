package org.example.service;

import org.example.entity.Sale;
import org.example.repository.SaleRepository;
import org.example.util.InputManager;

import java.util.List;

public class SaleService implements BaseService<Sale>{
    SaleRepository saleRepository;
    public SaleService() {
        saleRepository = new SaleRepository();
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

    @Override
    public void findById() {
        System.out.println("=== Affichage d'une vente ===");
        long id = InputManager.askInput("Id de la vente à afficher:", Long.class);
        Sale sale = saleRepository.getById(Sale.class, id);
        if(sale == null) {
            System.out.println("La vente avec id " + id + " n'a pas été trouvée");
        } else {
            System.out.println(sale);
        }
    }

    @Override
    public void displayAll() {
        List<Sale> sales = saleRepository.getAll();
        for(Sale sale : sales) {
            System.out.println(sale);
        }
    }

    public void create() {
        Sale sale = new Sale();
        System.out.println("=== Création d'une vente ===");

    }

    public void update() {
    }
}
