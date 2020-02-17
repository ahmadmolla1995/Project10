package articlemanagementsystem.services.viewarticles;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.exceptions.UserNotFoundException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface ViewArticlesUseCase {
    void viewAll() throws ArticleNotFoundException, UserSessionNotExistsException;
    void viewByWriterName(String writerName) throws UserNotFoundException, ArticleNotFoundException, UserSessionNotExistsException;
}

