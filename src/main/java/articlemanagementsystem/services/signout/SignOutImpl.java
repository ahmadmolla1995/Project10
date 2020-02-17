package articlemanagementsystem.services.signout;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.model.User;
import articlemanagementsystem.util.AuthenticationService;
import articlemanagementsystem.exceptions.UserAlreadySignedOutException;


@Service
public class SignOutImpl implements SignOutUseCase {
    @Override
    public void signOut() throws UserAlreadySignedOutException {
        User user = AuthenticationService.getCurrentUser();
        if(user == null)
            throw new UserAlreadySignedOutException("The user is already signed out!");

        AuthenticationService.removeCurrentUser();
    }
}
