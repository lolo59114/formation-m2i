package org.example.service;

import org.example.entity.Article;
import org.example.entity.ArticleElectronic;
import org.example.entity.ArticleFood;
import org.example.entity.ArticleMode;
import org.example.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;

public class ArticleService implements BaseService<Article> {
    ArticleRepository articleRepository;
    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    @Override
    public boolean delete(long id) {
        Article article = articleRepository.getById(Article.class, id);
        if(article == null) {
            System.out.println("L'article avec id " + id + " n'a pas été trouvé");
            return false;
        } else {
            return articleRepository.delete(article);
        }
    }

    @Override
    public Article findById(long id) {
        return articleRepository.getById(Article.class, id);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.getAll();
    }

    public boolean create(Article article) {
        return articleRepository.save(article);
    }

    public Article createArticleBase(String description, double price, int quantity, LocalDate restockDate, String type) {
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


    public boolean update(Article article) {
        return articleRepository.update(article);
    }

}
