package articlemanagementsystem.services.signin;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.model.User;
import articlemanagementsystem.exceptions.IllegalPasswordException;
import articlemanagementsystem.exceptions.UserAlreadySignedInException;
import articlemanagementsystem.exceptions.UserNotFoundException;


@UseCase
public interface SignInUseCase {
    User signIn(String username, String password) throws UserAlreadySignedInException, UserNotFoundException, IllegalPasswordException;
}
