package articlemanagementsystem.services.writearticle;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.CategoryNotFoundException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.TagNotFoundException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;

import javax.persistence.NoResultException;


@UseCase
public interface CreateArticleUseCase {
    void write() throws NoResultException, UserSessionNotExistsException, InvalidCommandException, CategoryNotFoundException, TagNotFoundException;
}

