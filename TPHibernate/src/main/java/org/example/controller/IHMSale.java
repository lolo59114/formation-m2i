package org.example.controller;

import org.example.entity.*;
import org.example.service.ArticleService;
import org.example.service.CustomerService;
import org.example.service.SaleLineService;
import org.example.service.SaleService;
import org.example.util.DisplayManager;
import org.example.util.InputManager;
import org.example.util.SaleState;

import java.time.LocalDate;
import java.util.List;

public class IHMSale {
    private SaleService saleService;
    private SaleLineService saleLineService;
    private ArticleService articleService;
    private CustomerService customerService;

    public IHMSale() {
        saleService = new SaleService();
        saleLineService = new SaleLineService();
        articleService = new ArticleService();
        customerService = new CustomerService();
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
                5. Consulter les ventes d'un produit
                6. Consulter les ventes d'une période
                0. Retour au menu principal
                """);
            choice = InputManager.askInputChoice(6);
            switch (choice) {
                case "1" -> createSale();
                case "2" -> cancelSale();
                case "3" -> findSaleById();
                case "4" -> displayAllSales();
                case "5" -> displaySalesByArticle();
                case "6" -> displaySalesByPeriod();
                default -> {
                    return;
                }
            }
            InputManager.askBeforeContinue();
        }
    }

    private void createSale() {
        System.out.println("=== Création d'une vente ===");
        List<Article> articles = articleService.getAll();

        List<Customer> customers = customerService.getAll();
        DisplayManager.displayList(customers, Customer.class);
        long idCustomer = InputManager.askInput("Choisissez l'id du client:", Long.class);
        Customer customer = customerService.findById(idCustomer);
        if(customer == null) {
            System.out.println("Le client avec id " + idCustomer + " n'a pas été trouvé");
        } else {
            Sale newSale = Sale.builder()
                    .state(SaleState.ON_GOING)
                    .saleDate(LocalDate.now())
                    .customer(customer)
                    .build();

            if(saleService.create(newSale)) {
                double totalPrice = 0;
                while (true) {
                    DisplayManager.displayList(articles, Article.class);
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

    private void cancelSale() {
        System.out.println("=== Annulation d'une vente ===");
        displayAllSales();
        Long idSale = InputManager.askInput("Choisissez l'id de la vente à annuler:", Long.class);
        Sale sale = saleService.findById(idSale);
        if(sale == null || sale.getState() == SaleState.CANCELLED) {
            System.out.println("La vente avec id " + idSale + " n'existe pas ou ne peut pas être annulé");
        } else {
            System.out.println(sale);
            DisplayManager.displayList(sale.getSaleLines(), SaleLine.class);
            String confirmation = InputManager.askInput("Etes-vous sûr de vouloir annuler cette vente ?(y/n)", String.class);
            if(confirmation.equalsIgnoreCase("y")) {
                if(saleService.cancel(sale)) {
                    System.out.println("La vente a bien été annulée.");
                }
            }
        }
    }

    private void findSaleById() {
        System.out.println("=== Affichage d'une vente ===");
        long id = InputManager.askInput("Id de la vente à afficher:", Long.class);
        Sale sale = saleService.findById(id);
        if(sale == null) {
            System.out.println("La vente avec id " + id + " n'a pas été trouvée");
        } else {
            System.out.println(sale);
            DisplayManager.displayList(sale.getSaleLines(), SaleLine.class);
        }
    }

    private void displayAllSales() {
        List<Sale> sales = saleService.getAll();
        DisplayManager.displayList(sales, Sale.class);
    }

    private void displaySalesByArticle() {
        System.out.println("=== Les ventes d'un article ===");
        List<Article> articles = articleService.getAll();
        DisplayManager.displayList(articles, Article.class);
        long id = InputManager.askInput("Spécifiez l'id de l'article:", Long.class);
        List<Sale> sales = saleService.getSalesByIdArticle(id);
        DisplayManager.displayList(sales, Sale.class);
    }

    private void displaySalesByPeriod() {
        System.out.println("=== Les ventes d'une période ===");
        LocalDate period = InputManager.askInput("Choisissez une date (yyyy-MM-dd):", LocalDate.class);
        List<Sale> sales = saleService.getSalesBySaleDate(period);
        DisplayManager.displayList(sales, Sale.class);
    }
}
