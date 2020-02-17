package articlemanagementsystem.services.removearticle;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Article;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.repositories.ArticleRepository;
import articlemanagementsystem.util.AuthenticationService;

import javax.persistence.NoResultException;


@Service
public class RemoveArticleImpl implements RemoveArticleUseCase {
    @Override
    public void remove(Long articleID) throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in!");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("Only admin can remove the article.");


        try {
            ArticleRepository repository = ArticleRepository.getInstance();
            Article article = repository.find("id", articleID.toString());
            repository.delete(article);

        } catch (NoResultException e) {
            throw new ArticleNotFoundException("Article ID not found!");
        }
    }
}
