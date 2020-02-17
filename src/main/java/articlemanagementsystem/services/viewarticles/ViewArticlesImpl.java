package articlemanagementsystem.services.viewarticles;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Article;
import articlemanagementsystem.model.User;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.exceptions.UserNotFoundException;
import articlemanagementsystem.repositories.ArticleRepository;
import articlemanagementsystem.repositories.UserRepository;
import articlemanagementsystem.util.AuthenticationService;

import java.util.List;


@Service
public class ViewArticlesImpl implements ViewArticlesUseCase {
    @Override
    public void viewAll() throws ArticleNotFoundException, UserSessionNotExistsException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in!");

        List<Article> articles = ArticleRepository.getInstance().findAll();
        if(articles.isEmpty())
            throw new ArticleNotFoundException("There isn't any article in database!");

        System.out.println("\nArticles\n===================================");
        for (Article article : articles) {
            System.out.printf("ID:%d\t", article.getId());
            System.out.printf("title:%s\t", article.getTitle());
            System.out.printf("brief:%s\n", article.getBrief());
        }
    }

    @Override
    public void viewByWriterName(String writerName) throws ArticleNotFoundException, UserNotFoundException, UserSessionNotExistsException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in!");


        User writer;
        try {
            writer = UserRepository.getInstance().find("username", "\'" + writerName + "\'");
        } catch (Exception e) {
            throw new UserNotFoundException("There isn't writer name in database!");
        }


        List<Article> writerArticles = ArticleRepository.getInstance().findAll("writer_id", writer.getId().toString());
        if(writerArticles.isEmpty())
            throw new ArticleNotFoundException("The writer has not written any article yet!");

        for (Article article: writerArticles)
            System.out.println(article.toString());
    }
}
