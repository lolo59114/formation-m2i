package org.example.repository;



import org.example.entity.Article;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleRepository extends BaseRepository<Article>{
    public ArticleRepository() {
        super();
    }

    public List<Article> getAll (){
        openSession();
        Query<Article> query = session.createQuery("from Article", Article.class);
        return query.list();
    }
}
