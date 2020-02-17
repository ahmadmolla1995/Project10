package articlemanagementsystem.services.createtag;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Tag;
import articlemanagementsystem.exceptions.TagAlreadyExistsException;
import articlemanagementsystem.repositories.TagRepository;
import articlemanagementsystem.util.AuthenticationService;



@Service
public class CreateTagImpl implements CreateTagUseCase {
    @Override
    public void createTag(String title) throws TagAlreadyExistsException, UserSessionNotExistsException, InvalidCommandException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in! Please log in first");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("Only admin can create new tag!");


        try {
            TagRepository repository = TagRepository.getInstance();
            repository.save(new Tag(null, title));
        } catch (Exception e) {
            throw new TagAlreadyExistsException("Tag already exists!");
        }
    }
}
