package articlemanagementsystem.services.publishcancellation;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Article;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.repositories.ArticleRepository;
import articlemanagementsystem.util.AuthenticationService;


@Service
public class PublishCancellationImpl implements PublishCancellationUseCase{
    @Override
    public void publishCancel(Long articleID) throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in!");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("Only admin can cancel publish.");


        try {
            ArticleRepository repository = ArticleRepository.getInstance();
            Article article = repository.find("id", articleID.toString());
            article.publishCancel();
            repository.update(article);

        } catch (Exception e) {
            throw new ArticleNotFoundException("article ID not found!");
        }
    }
}
