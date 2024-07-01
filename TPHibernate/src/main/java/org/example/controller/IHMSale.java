package org.example.controller;

import org.example.service.SaleService;
import org.example.util.InputManager;

public class IHMSale {
    private SaleService saleService;

    public IHMSale() {
        saleService = new SaleService();
    }

    public void start() {
        String choice;
        while (true) {
            System.out.println("""
                === Menu Inventaire ===
                1. Ajouter une vente
                2. Modifier une vente
                3. Supprimer une vente
                4. Consulter une vente
                5. Consulter toutes les ventes
                0. Retour au menu principal
                """);
            choice = InputManager.askInputChoice(5);
            switch (choice) {
                case "1" -> saleService.create();
                case "2" -> saleService.update();
                case "3" -> saleService.delete();
                case "4" -> saleService.findById();
                case "5" -> saleService.displayAll();
                default -> {
                    return;
                }
            }
            InputManager.askBeforeContinue();
        }
    }
}
