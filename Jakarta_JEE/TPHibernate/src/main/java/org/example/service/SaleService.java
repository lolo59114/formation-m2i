package org.example.service;

import org.example.entity.Article;
import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.example.repository.ArticleRepository;
import org.example.repository.SaleLineRepository;
import org.example.repository.SaleRepository;
import org.example.util.SaleState;

import java.time.LocalDate;
import java.util.List;

public class SaleService implements BaseService<Sale>{
    SaleRepository saleRepository;
    SaleLineRepository saleLineRepository;
    ArticleRepository articleRepository;
    public SaleService() {
        saleRepository = new SaleRepository();
        saleLineRepository = new SaleLineRepository();
        articleRepository = new ArticleRepository();
    }

    @Override
    public boolean delete(long id) {
        Sale sale = saleRepository.getById(Sale.class, id);
        if(sale == null) {
            System.out.println("La vente avec id " + id + " n'a pas été trouvée");
            return false;
        }

        return saleRepository.delete(sale);
    }

    @Override
    public Sale findById(long id) {
        return saleRepository.getById(Sale.class, id);
    }


    @Override
    public List<Sale> getAll() {
        return saleRepository.getAll();
    }

    public boolean create(Sale newSale) {
        return saleRepository.save(newSale);
    }

    @Override
    public boolean update(Sale sale) {
        return saleRepository.update(sale);
    }

    public List<Sale> getSalesByIdArticle(long id) {
        return saleRepository.getSalesByIdArticle(id);
    }

    public List<Sale> getSalesBySaleDate(LocalDate period) {
        return saleRepository.getSalesBySaleDate(period);
    }

    public boolean cancel(Sale sale) {
        sale.setState(SaleState.CANCELLED);
        for(SaleLine saleLine : sale.getSaleLines()) {
            int newQuantity = saleLine.getId().getArticle().getQuantityAvailable() + saleLine.getQuantity();
            Article article = saleLine.getId().getArticle();
            article.setQuantityAvailable(newQuantity);
            articleRepository.update(article);
        }
        return update(sale);
    }
}
