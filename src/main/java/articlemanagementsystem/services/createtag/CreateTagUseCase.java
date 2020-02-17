package articlemanagementsystem.services.createtag;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.TagAlreadyExistsException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface CreateTagUseCase {
    void createTag(String title) throws InvalidCommandException, UserSessionNotExistsException, TagAlreadyExistsException;
}
