package articlemanagementsystem.services.removearticle;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface RemoveArticleUseCase {
    void remove(Long articleID) throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException;
}
