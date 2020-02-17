package articlemanagementsystem.services.createcategory;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Category;
import articlemanagementsystem.exceptions.CategoryAlreadyExistsException;
import articlemanagementsystem.repositories.CategoryRepository;
import articlemanagementsystem.util.AuthenticationService;


@Service
public class CreateCategoryImpl implements CreateCategoryUseCase {

    @Override
    public void createCategory(String title, String description) throws InvalidCommandException, CategoryAlreadyExistsException, UserSessionNotExistsException {
        if(AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in! Please log in first");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("Only admin can create the new category!");


        try {
            CategoryRepository repository = CategoryRepository.getInstance();
            repository.save(new Category(null, title, description));
        } catch (Exception e) {
            throw new CategoryAlreadyExistsException("Category already exists!");
        }
    }
}

