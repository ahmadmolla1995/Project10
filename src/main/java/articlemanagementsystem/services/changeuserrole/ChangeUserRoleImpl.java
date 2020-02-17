package articlemanagementsystem.services.changeuserrole;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.InvalidUserRoleException;
import articlemanagementsystem.exceptions.RoleNotFoundException;
import articlemanagementsystem.exceptions.UserNotFoundException;
import articlemanagementsystem.model.Role;
import articlemanagementsystem.model.User;
import articlemanagementsystem.repositories.RoleRepository;
import articlemanagementsystem.repositories.UserRepository;
import articlemanagementsystem.util.AuthenticationService;



@Service
public class ChangeUserRoleImpl implements ChangeUserRoleUseCase {
    @Override
    public void changeRole(Long userID, String newRole) throws InvalidCommandException, UserNotFoundException, InvalidUserRoleException, RoleNotFoundException {
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("admin"))
            throw new InvalidCommandException("only admin can change user roles in system!");

        User user;
        try {
            user = UserRepository.getInstance().find("id", userID.toString());
        } catch (Exception e) {
            throw new UserNotFoundException("There isn't user with this userID");
        }

        if (user.getUserRole().equals("admin") || newRole.equals("admin"))
            throw new InvalidUserRoleException("You can not change system admin!");

        try {
            Role role = RoleRepository.getInstance().find("title", "\'" + newRole + "\'");
            user.setRole(role.getTitle());
            UserRepository.getInstance().update(user);
        } catch (Exception e) {
            throw new RoleNotFoundException("Invalid Role! The new user role not found in table!");
        }
    }
}

