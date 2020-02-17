package articlemanagementsystem.services.publishconfirmation;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Article;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.repositories.ArticleRepository;
import articlemanagementsystem.util.AuthenticationService;

import javax.persistence.NoResultException;
import java.time.LocalDate;


@Service
public class PublishArticleImpl implements PublishArticleUseCase{
    @Override
    public void publishConfirm(Long articleID) throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in!");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("Only admin can publish the article.");


        try {
            ArticleRepository repository = ArticleRepository.getInstance();
            Article article = repository.find("id", articleID.toString());
            article.publishConfirm();
            article.setPublishDate(LocalDate.now().toString());
            repository.update(article);

        } catch (NoResultException e) {
            throw new ArticleNotFoundException("Article ID not found!");
        }
    }
}
