package articlemanagementsystem.repositories;

import articlemanagementsystem.model.Article;


public class ArticleRepository extends CrudRepository<Article, Long> {
    private static ArticleRepository articleRepository;

    private ArticleRepository() {}

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    public static ArticleRepository getInstance() {
        if (articleRepository == null)
            articleRepository = new ArticleRepository();
        return articleRepository;
    }
}

