package articlemanagementsystem.services.createrole;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.RoleAlreadyExistsException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;


@UseCase
public interface CreateRoleUseCase{
    void createRole(String role) throws InvalidCommandException, UserSessionNotExistsException, RoleAlreadyExistsException;
}
