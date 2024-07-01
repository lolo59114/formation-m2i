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
        for(Article article : articles) {
            System.out.println(article);
        }
    }

    public void create() {
        Article newArticle;
        System.out.println("=== Création d'un article ===");
        System.out.println("Type: \n1. Electronique\n2. Nourriture\n3. Vêtement\n");
        String type = InputManager.askInputChoice(3);
        String description = InputManager.askInput("Description:", String.class);
        double price = InputManager.askInput("Prix:", Double.class);
        int quantity = InputManager.askInput("Quantité en stock:", Integer.class);
//        LocalDate restockDate = InputManager.askInput("Date de restock (yyyy-MM-dd):", LocalDate.class);
        LocalDate restockDate = LocalDate.now();
        newArticle = createArticleBase(description, price, quantity, restockDate, type);
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
        if(articleRepository.save(newArticle))
            System.out.println("L'article a bien été créé.");

    }

    private Article createArticleBase(String description, double price, int quantity, LocalDate restockDate, String type) {
        Article newArticle = null;
        switch (type) {
            case "1" -> newArticle = new ArticleElectronic();
            case "2" -> newArticle = new ArticleFood();
            case "3" -> newArticle = new ArticleMode();
        }
        assert newArticle != null;
        newArticle.setPrice(price);
        newArticle.setDescription(description);
        newArticle.setPrice(price);
        newArticle.setQuantityAvailable(quantity);
        newArticle.setRestockDate(restockDate);
        return newArticle;
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
        // Mise à jour de l'article
        article.setDescription("".equals(description) ? article.getDescription() : description);
        article.setPrice(price == 0 ? article.getPrice() : price);
        article.setQuantityAvailable(quantity == 0 ? article.getQuantityAvailable() : quantity);
        article.setRestockDate(restockDate);
        switch (article.getClass().getSimpleName()) {
            case "ArticleElectronic" -> {
                long durationInMinutes = InputManager.askInput("Durée de batterie(" + ((ArticleElectronic)article).getDurationInMinutes() +") (minutes):", Long.class);
                ArticleElectronic updatedArticle = (ArticleElectronic) article;
                updatedArticle.setDurationInMinutes(durationInMinutes == 0 ? updatedArticle.getDurationInMinutes() : durationInMinutes);
                articleRepository.update(updatedArticle);
            }
            case "ArticleFood" -> {
                LocalDate expirationDate = InputManager.askInput("Date d'expiration (" + ((ArticleFood)article).getExpirationDate() + ") (yyyy-MM-dd):", LocalDate.class);
                ArticleFood updatedArticle = (ArticleFood) article;
                updatedArticle.setExpirationDate(expirationDate);
                articleRepository.update(updatedArticle);
            }
            case "ArticleMode" -> {
                System.out.println("Catégorie actuelle : " + ((ArticleMode)article).getCategory().name());
                CategoryMode categoryMode = InputManager.askFromEnum(CategoryMode.values(), "catégories");
                String taille = InputManager.askInput("Taille("+ ((ArticleMode)article).getTaille() + "):", String.class);
                ArticleMode updatedArticle = (ArticleMode) article;
                updatedArticle.setCategory(categoryMode);
                updatedArticle.setTaille("".equals(taille) ? updatedArticle.getTaille() : taille);
                articleRepository.update(updatedArticle);
            }
        }
    }

    public void restockArticle() {
        System.out.println("=== Restockage d'un article ===");
        displayAll();
        long id = InputManager.askInput("Spécifiez l'id de l'article à restocker:", Long.class);
        Article articleToRestock = articleRepository.getById(Article.class, id);
        int addedStock = 0;
        int cpt = 0;
        do {
            // Sécurité pour éviter une boucle infinie
            cpt++;
            addedStock = InputManager.askInput("Quel stock voulez-vous ajouter (doit être positif) ?", Integer.class);
        } while (addedStock < 0 || cpt > 5);

        int newStock = addedStock + articleToRestock.getQuantityAvailable();
        articleToRestock.setRestockDate(LocalDate.now());
        articleToRestock.setQuantityAvailable(newStock);
        articleRepository.update(articleToRestock);
    }
}
