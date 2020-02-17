package articlemanagementsystem.services.createrole;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.RoleAlreadyExistsException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Role;
import articlemanagementsystem.repositories.RoleRepository;
import articlemanagementsystem.util.AuthenticationService;


@Service
public class CreateRoleImpl implements CreateRoleUseCase {
    @Override
    public void createRole(String role) throws InvalidCommandException, UserSessionNotExistsException, RoleAlreadyExistsException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in! Please log in first");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("Only admin can create new role!");


        try {
            RoleRepository repository = RoleRepository.getInstance();
            repository.save(new Role(null, role));
        } catch (Exception e) {
            throw new RoleAlreadyExistsException("The role title already exists!");
        }
    }
}
