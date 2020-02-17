package articlemanagementsystem.services.signup;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidUserRoleException;
import articlemanagementsystem.exceptions.RoleNotFoundException;
import articlemanagementsystem.model.User;
import articlemanagementsystem.exceptions.NationalCodeException;
import articlemanagementsystem.repositories.RoleRepository;
import articlemanagementsystem.repositories.UserRepository;



@Service
public class SignUpImpl implements SignUpUseCase {
    @Override
    public User signUp(String username, String nationalID, String birthday, String userRole) throws NationalCodeException, InvalidUserRoleException, RoleNotFoundException {
        validateUserRole(userRole);
        validateNationalID(nationalID);

        UserRepository repository = UserRepository.getInstance();
        return repository.save(new User(null, username, nationalID, nationalID, birthday, userRole));
    }

    private void validateUserRole(String userRole) throws InvalidUserRoleException, RoleNotFoundException {
        if (userRole.equals("admin"))
            throw new InvalidUserRoleException("Invalid user role! Admin is already in database.");

        try {
            RoleRepository.getInstance().find("title", "\'" + userRole + "\'");
        } catch (Exception e) {
            throw new RoleNotFoundException("Invalid user role! The role not found in table.");
        }
    }

    private void validateNationalID(String nationalID) throws NationalCodeException {
        if (nationalID.length() != 10)
            throw new NationalCodeException("National code's length should be 10.");
        if (!nationalID.matches("[0-9]+"))
            throw new NationalCodeException("The national code should only consist of digits");
    }
}
