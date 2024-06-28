package org.example.service;

import org.example.entity.Article;
import org.example.entity.ArticleElectronic;
import org.example.entity.ArticleFood;
import org.example.entity.ArticleMode;
import org.example.repository.ArticleRepository;
import org.example.util.CategoryMode;
import org.example.util.InputManager;

import java.time.LocalDate;
import java.util.List;

public class ArticleService implements BaseService<Article> {
    ArticleRepository articleRepository;
    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    @Override
    public void delete() {
        System.out.println("=== Suppression d'un article ===");
        long id = InputManager.askInput("Id de l'article à supprimer:", Long.class);
        Article article = articleRepository.getById(Article.class, id);
        if(article == null) {
            System.out.println("L'article avec id " + id + " n'a pas été trouvé");
        } else {
            articleRepository.delete(article);
        }
    }

    @Override
    public void findById() {
        System.out.println("=== Affichage d'un article ===");
        long id = InputManager.askInput("Id de l'article à afficher:", Long.class);
        Article article = articleRepository.getById(Article.class, id);
        if(article == null)
            System.out.println("L'article avec id " + id + " n'a pas été trouvé");
        else {
            System.out.println(article);
        }
    }

    @Override
    public void displayAll() {
        List<Article> articles = articleRepository.getAll();
        System.out.println(articles);
    }

    public void create() {
        Article newArticle;
        System.out.println("=== Création d'un article ===");
        System.out.println("Type: \n1. Electronique\n2. Nourriture\n3. Vêtement\n");
        String type = InputManager.askInputChoice(3);
        String description = InputManager.askInput("Description:", String.class);
        double price = InputManager.askInput("Prix:", Double.class);
        int quantity = InputManager.askInput("Quantité en stock:", Integer.class);
        LocalDate restockDate = InputManager.askInput("Date de restock (yyyy-MM-dd):", LocalDate.class);
        
        switch (type) {
            // Electronique
            case "1" -> {
                long durationInMinutes = InputManager.askInput("Durée de batterie (minutes):", Long.class);
                newArticle = ArticleElectronic.builder()
                        .description(description)
                        .price(price)
                        .quantityAvailable(quantity)
                        .restockDate(restockDate)
                        .durationInMinutes(durationInMinutes)
                        .build();
                articleRepository.save(newArticle);
            }
            // Food
            case "2" -> {
                LocalDate expirationDate = InputManager.askInput("Date d'expiration (yyyy-MM-dd):", LocalDate.class);
                newArticle = ArticleFood.builder()
                        .description(description)
                        .price(price)
                        .quantityAvailable(quantity)
                        .restockDate(restockDate)
                        .expirationDate(expirationDate)
                        .build();
                articleRepository.save(newArticle);
            }
            // Mode
            case "3" -> {
                CategoryMode categoryMode = InputManager.askFromEnum(CategoryMode.values(), "catégories");
                String taille = InputManager.askInput("Taille(XS,S,M,L,XL,etc.):", String.class);
                newArticle = ArticleMode.builder()
                        .description(description)
                        .price(price)
                        .quantityAvailable(quantity)
                        .restockDate(restockDate)
                        .category(categoryMode)
                        .taille(taille)
                        .build();
                articleRepository.save(newArticle);
            }
        }
    }


    public void update() {
        System.out.println("=== Modification d'un article ===");
        long id = InputManager.askInput("Id de l'article à modifier:", Long.class);
        Article article = articleRepository.getById(Article.class, id);
        System.out.println(article);
        String description = InputManager.askInput("Description de l'article(" + article.getDescription() + "):", String.class);
        double price = InputManager.askInput("Prix("+ article.getPrice() + "):", Double.class);
        int quantity = InputManager.askInput("Quantité en stock(" + article.getQuantityAvailable() + "):", Integer.class);
        LocalDate restockDate = InputManager.askInput("Date de restock(" + article.getRestockDate() + ") (yyyy-MM-dd):", LocalDate.class);

        switch (article.getClass().getSimpleName()) {
            case "ArticleElectronic" -> {
                long durationInMinutes = InputManager.askInput("Durée de batterie(" + ((ArticleElectronic)article).getDurationInMinutes() +") (minutes):", Long.class);
                ArticleElectronic updatedArticle = (ArticleElectronic) article;
                updatedArticle = ArticleElectronic.builder()
                        .id(article.getId())
                        .description(description)
                        .price(price)
                        .quantityAvailable(quantity)
                        .restockDate(restockDate)
                        .durationInMinutes(durationInMinutes)
                        .build();
                articleRepository.save(updatedArticle);
            }
            case "ArticleFood" -> {
                LocalDate expirationDate = InputManager.askInput("Date d'expiration (" + ((ArticleFood)article).getExpirationDate() + ") (yyyy-MM-dd):", LocalDate.class);
                ArticleFood updatedArticle = (ArticleFood) article;
                        ArticleFood.builder()
                        .id(article.getId())
                        .description(description)
                        .price(price)
                        .quantityAvailable(quantity)
                        .restockDate(restockDate)
                        .expirationDate(expirationDate)
                        .build();
                articleRepository.save(updatedArticle);
            }
            case "ArticleMode" -> {
                System.out.println("Catégorie actuelle : " + ((ArticleMode)article).getCategory().name());
                CategoryMode categoryMode = InputManager.askFromEnum(CategoryMode.values(), "catégories");
                String taille = InputManager.askInput("Taille("+ ((ArticleMode)article).getTaille() + "):", String.class);
                ArticleMode updatedArticle = (ArticleMode) article;
                updatedArticle.setDescription(description);
                updatedArticle.setPrice(price);
                updatedArticle.setCategory(categoryMode);
                updatedArticle.setQuantityAvailable(quantity);
                updatedArticle.setTaille(taille);
                updatedArticle.setRestockDate(restockDate);
//                        ArticleMode.builder()
//                        .id(article.getId())
//                        .description(description)
//                        .price(price)
//                        .quantityAvailable(quantity)
//                        .restockDate(restockDate)
//                        .category(categoryMode)
//                        .taille(taille)
//                        .build();
                articleRepository.save(updatedArticle);
            }
        }
    }
}
