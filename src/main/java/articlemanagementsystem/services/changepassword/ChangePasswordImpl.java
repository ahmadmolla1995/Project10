package articlemanagementsystem.services.changepassword;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.User;
import articlemanagementsystem.exceptions.IllegalPasswordException;
import articlemanagementsystem.repositories.UserRepository;
import articlemanagementsystem.util.AuthenticationService;

import java.util.Scanner;


@Service
public class ChangePasswordImpl implements ChangePasswordUseCase {
    @Override
    public void changePassword() throws UserSessionNotExistsException, IllegalPasswordException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("old password:");
        String oldPassword = scanner.next();
        System.out.print("new password:");
        String newPassword = scanner.next();
        System.out.print("new password again:");
        String newPasswordAgain = scanner.next();

        User user = AuthenticationService.getCurrentUser();


        if (user == null)
            throw new UserSessionNotExistsException("user is not logged in!");
        if (!oldPassword.equals(user.getPassword()))
            throw new IllegalPasswordException("Wrong password! Enter again.");
        else if (newPassword.equals(oldPassword))
            throw new IllegalPasswordException("New and old passwords are the same!");
        else if (!newPassword.equals(newPasswordAgain))
            throw new IllegalPasswordException("Entered passwords aren't similar.");
        else if (newPassword.length() < 8)
            throw new IllegalPasswordException("Password should have at least 8 characters.");
        else if (newPassword.length() > 30)
            throw new IllegalPasswordException("Password should have maximum 30 characters.");
        else {
            user.setPassword(newPassword);
            UserRepository.getInstance().update(user);

            AuthenticationService.setCurrentUser(user);
        }

    }
}
