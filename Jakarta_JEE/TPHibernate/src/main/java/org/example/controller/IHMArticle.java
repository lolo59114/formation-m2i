package org.example.controller;

import org.example.entity.*;
import org.example.service.ArticleService;
import org.example.util.CategoryMode;
import org.example.util.DisplayManager;
import org.example.util.InputManager;

import java.time.LocalDate;
import java.util.List;

public class IHMArticle {
    private ArticleService articleService;

    public IHMArticle() {
        articleService = new ArticleService();
    }

    public void start() {
        String choice;
        while (true) {
            System.out.println("""
                === Menu Inventaire ===
                1. Ajouter un article
                2. Modifier un article
                3. Supprimer un article
                4. Consulter un article
                5. Consulter tous les articles
                6. Restocker les articles
                0. Retour au menu principal
                """);
            choice = InputManager.askInputChoice(6);
            switch (choice) {
                case "1" -> createArticle();
                case "2" -> updateArticle();
                case "3" -> deleteArticleById();
                case "4" -> findArticleById();
                case "5" -> displayAllArticles();
                case "6" -> restockArticle();
                default -> {
                    return;
                }
            }
            InputManager.askBeforeContinue();
        }
    }

    private void createArticle() {
        Article newArticle;
        System.out.println("=== Création d'un article ===");
        System.out.println("Type: \n1. Electronique\n2. Nourriture\n3. Vêtement\n");
        String type = InputManager.askInputChoice(3);
        String description = InputManager.askInput("Description:", String.class);
        double price = InputManager.askInput("Prix:", Double.class);
        int quantity = InputManager.askInput("Quantité en stock:", Integer.class);
        LocalDate restockDate = LocalDate.now();
        newArticle = articleService.createArticleBase(description, price, quantity, restockDate, type);
        switch (type) {
            // Electronique
            case "1" -> {
                long durationInMinutes = InputManager.askInput("Durée de batterie (minutes):", Long.class);
                ((ArticleElectronic) newArticle).setDurationInMinutes(durationInMinutes);
            }
            // Food
            case "2" -> {
                LocalDate expirationDate = InputManager.askInput("Date d'expiration (yyyy-MM-dd):", LocalDate.class);
                ((ArticleFood) newArticle).setExpirationDate(expirationDate);
            }
            // Mode
            case "3" -> {
                CategoryMode categoryMode = InputManager.askFromEnum(CategoryMode.values(), "catégories");
                String taille = InputManager.askInput("Taille(XS,S,M,L,XL,etc.):", String.class);
                ((ArticleMode) newArticle).setCategory(categoryMode);
                ((ArticleMode) newArticle).setTaille(taille);
            }
        }
        if(articleService.create(newArticle))
            System.out.println("L'article a bien été créé.");
    }

    private void updateArticle() {
        System.out.println("=== Modification d'un article ===");
        long id = InputManager.askInput("Id de l'article à modifier:", Long.class);
        Article article = articleService.findById(id);
        if (article == null) {
            System.out.println("L'article avec id " + id + " n'a pas été trouvé");
        } else {
            System.out.println(article);
            String description = InputManager.askInput("Description de l'article(" + article.getDescription() + "):", String.class);
            double price = InputManager.askInput("Prix("+ article.getPrice() + "):", Double.class);
            int quantity = InputManager.askInput("Quantité en stock(" + article.getQuantityAvailable() + "):", Integer.class);
            // Mise à jour de l'article
            article.setDescription("".equals(description) ? article.getDescription() : description);
            article.setPrice(price == 0 ? article.getPrice() : price);
            article.setQuantityAvailable(quantity == 0 ? article.getQuantityAvailable() : quantity);
            switch (article.getClass().getSimpleName()) {
                case "ArticleElectronic" -> {
                    long durationInMinutes = InputManager.askInput("Durée de batterie(" + ((ArticleElectronic)article).getDurationInMinutes() +") (minutes):", Long.class);
                    ArticleElectronic updatedArticle = (ArticleElectronic) article;
                    updatedArticle.setDurationInMinutes(durationInMinutes == 0 ? updatedArticle.getDurationInMinutes() : durationInMinutes);
                }
                case "ArticleFood" -> {
                    LocalDate expirationDate = InputManager.askInput("Date d'expiration (" + ((ArticleFood)article).getExpirationDate() + ") (yyyy-MM-dd):", LocalDate.class);
                    ArticleFood updatedArticle = (ArticleFood) article;
                    updatedArticle.setExpirationDate(expirationDate);
                }
                case "ArticleMode" -> {
                    System.out.println("Catégorie actuelle : " + ((ArticleMode)article).getCategory().name());
                    CategoryMode categoryMode = InputManager.askFromEnum(CategoryMode.values(), "catégories");
                    String taille = InputManager.askInput("Taille("+ ((ArticleMode)article).getTaille() + "):", String.class);
                    ArticleMode updatedArticle = (ArticleMode) article;
                    updatedArticle.setCategory(categoryMode);
                    updatedArticle.setTaille("".equals(taille) ? updatedArticle.getTaille() : taille);
                }
            }
            if(articleService.update(article)) {
                System.out.println("L'article a bien été modifié.");
            }
        }
    }

    private void deleteArticleById() {
        System.out.println("=== Suppression d'un article ===");
        long id = InputManager.askInput("Id de l'article à supprimer:", Long.class);
        if(articleService.delete(id)) {
            System.out.println("L'article a bien été supprimé.");
        }
    }

    private void findArticleById() {
        System.out.println("=== Affichage d'un article ===");
        long id = InputManager.askInput("Id de l'article à afficher:", Long.class);
        Article article = articleService.findById(id);
        if(article == null)
            System.out.println("L'article avec id " + id + " n'a pas été trouvé");
        else {
            System.out.println(article);
        }
    }

    private void displayAllArticles() {
        List<Article> articles = articleService.getAll();
        DisplayManager.displayList(articles, Article.class);
    }

    private void restockArticle() {
        System.out.println("=== Restockage d'un article ===");
        displayAllArticles();
        long id = InputManager.askInput("Spécifiez l'id de l'article à restocker:", Long.class);
        Article articleToRestock = articleService.findById(id);
        if(articleToRestock == null) {
            System.out.println("L'article avec id " + id + " n'a pas été trouvé");
        } else {
            int addedStock;
            int cpt = 0;
            do {
                // Sécurité pour éviter une boucle infinie
                cpt++;
                addedStock = InputManager.askInput("Quel stock voulez-vous ajouter (doit être positif) ?", Integer.class);
            } while (addedStock <= 0 && cpt < 5);
            if(addedStock > 0) {
                int newStock = addedStock + articleToRestock.getQuantityAvailable();
                articleToRestock.setRestockDate(LocalDate.now());
                articleToRestock.setQuantityAvailable(newStock);
                articleService.update(articleToRestock);
            }
        }
    }


}
