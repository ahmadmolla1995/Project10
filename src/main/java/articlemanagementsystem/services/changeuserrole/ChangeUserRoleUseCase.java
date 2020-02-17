package articlemanagementsystem.services.changeuserrole;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.InvalidUserRoleException;
import articlemanagementsystem.exceptions.RoleNotFoundException;
import articlemanagementsystem.exceptions.UserNotFoundException;


@UseCase
public interface ChangeUserRoleUseCase {
    void changeRole(Long userID, String newRole) throws InvalidCommandException, UserNotFoundException, InvalidUserRoleException, RoleNotFoundException;
}
