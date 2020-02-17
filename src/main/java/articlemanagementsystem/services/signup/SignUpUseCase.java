package articlemanagementsystem.services.signup;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.InvalidUserRoleException;
import articlemanagementsystem.model.User;
import articlemanagementsystem.exceptions.NationalCodeException;
import articlemanagementsystem.exceptions.UserRoleException;

import javax.management.relation.RoleNotFoundException;


@UseCase
public interface SignUpUseCase {
    User signUp(String username, String nationalCode, String birthday, String userRole) throws UserRoleException, NationalCodeException, RoleNotFoundException, InvalidUserRoleException, articlemanagementsystem.exceptions.RoleNotFoundException;
}
