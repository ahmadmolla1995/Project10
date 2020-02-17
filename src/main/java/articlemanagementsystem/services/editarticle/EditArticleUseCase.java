package articlemanagementsystem.services.editarticle;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface EditArticleUseCase {
    void edit() throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException;
}
