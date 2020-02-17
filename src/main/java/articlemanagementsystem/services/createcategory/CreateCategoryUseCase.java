package articlemanagementsystem.services.createcategory;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.CategoryAlreadyExistsException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface CreateCategoryUseCase {
    void createCategory(String title, String description) throws InvalidCommandException, CategoryAlreadyExistsException, UserSessionNotExistsException;
}
