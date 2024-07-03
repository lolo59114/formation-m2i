package org.example.controller;

import org.example.entity.Article;
import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.example.entity.SaleLinePK;
import org.example.service.ArticleService;
import org.example.service.SaleLineService;
import org.example.service.SaleService;
import org.example.util.InputManager;
import org.example.util.SaleState;

import java.util.ArrayList;
import java.util.List;

public class IHMSale {
    private SaleService saleService;
    private SaleLineService saleLineService;
    private ArticleService articleService;

    public IHMSale() {
        saleService = new SaleService();
        saleLineService = new SaleLineService();
        articleService = new ArticleService();
    }

    public void start() {
        String choice;
        while (true) {
            System.out.println("""
                === Menu Inventaire ===
                1. Ajouter une vente
                2. Annuler une vente
                3. Consulter une vente
                4. Consulter toutes les ventes
                0. Retour au menu principal
                """);
            choice = InputManager.askInputChoice(4);
            switch (choice) {
                case "1" -> create();
                case "2" -> cancel();
                case "3" -> saleService.findById();
                case "4" -> saleService.displayAll();
                default -> {
                    return;
                }
            }
            InputManager.askBeforeContinue();
        }
    }

    private void cancel() {
        System.out.println("=== Annulation d'une vente ===");
        saleService.displayAll();
        Long idSale = InputManager.askInput("Choisissez l'id de la vente à annuler:", Long.class);
        Sale sale = saleService.getById(idSale);
        if(sale == null) {
            System.out.println("La vente avec id " + idSale + " n'a pas été trouvée");
        } else {
            System.out.println(sale);
            for(SaleLine saleLine : sale.getSaleLines()) {
                System.out.println(saleLine);
            }

            String confirmation = InputManager.askInput("Etes-vous sûr de vouloir annuler cette vente ?(y/n)", String.class);
            if(confirmation.equalsIgnoreCase("y")) {
                sale.setState(SaleState.CANCELLED);
                saleService.update(sale);
            }
        }
    }

    private void create() {
        System.out.println("=== Création d'une vente ===");
        List<Article> articles = articleService.getArticles();
        Sale newSale = Sale.builder()
                .state(SaleState.ON_GOING)
                .build();
        if(saleService.create(newSale)) {
            double totalPrice = 0;
            while (true) {
                for(Article article : articles) {
                    System.out.println(article);
                }
                long id = InputManager.askInput("Donnez l'id de l'article à ajouter à la vente:", Long.class);
                // On vérifie que l'article choisi n'est pas déjà dans la vente
                Article article = articles.stream().filter(a -> a.getIdArticle() == id).findFirst().orElse(null);
                if (article != null) {
                    int quantity = InputManager.askInput("Donnez la quantité voulue:", Integer.class);
                    double subTotal = quantity * article.getPrice();
                    article.setQuantityAvailable(article.getQuantityAvailable() - quantity);
                    SaleLine saleLine = SaleLine.builder()
                            .id(new SaleLinePK(newSale, article))
                            .quantity(quantity)
                            .subTotalPrice(subTotal)
                            .build();
                    if(saleLineService.create(saleLine)) {
                        totalPrice += subTotal;
                        articles.remove(article);
                    } else {
                        System.out.println("Erreur lors de l'ajout de la ligne de vente");
                    }
                } else {
                    System.out.println("L'id de l'article n'existe pas ou l'article a déjà été ajouté à la vente");
                }
                String continueSale = InputManager.askInput("Voulez-vous ajouter un autre article ?(y/n)", String.class);
                if(!continueSale.equalsIgnoreCase("y")) {
                    break;
                }
            }
            newSale.setState(SaleState.FINISHED);
            newSale.setTotalPrice(totalPrice);
            if(saleService.update(newSale))
                System.out.println("La vente a bien été créée !");
        }
    }
}
