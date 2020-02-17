package articlemanagementsystem.services.publishcancellation;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface PublishCancellationUseCase {
    void publishCancel (Long articleID) throws InvalidCommandException, UserSessionNotExistsException, ArticleNotFoundException;
}
