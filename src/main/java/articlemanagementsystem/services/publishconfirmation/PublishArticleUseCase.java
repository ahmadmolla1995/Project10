package articlemanagementsystem.services.publishconfirmation;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface PublishArticleUseCase {
    void publishConfirm(Long articleID) throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException;
}
