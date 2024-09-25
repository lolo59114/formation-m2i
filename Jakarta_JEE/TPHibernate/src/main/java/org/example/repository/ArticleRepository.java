package org.example.repository;



import org.example.entity.Article;
import org.example.entity.Sale;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleRepository extends BaseRepository<Article>{
    public ArticleRepository() {
        super();
    }

    public List<Article> getAll (){
        openSession();
        Query<Article> query = session.createQuery("from Article", Article.class);
        List<Article> articles = query.list();
        session.close();
        return articles;
    }


}
