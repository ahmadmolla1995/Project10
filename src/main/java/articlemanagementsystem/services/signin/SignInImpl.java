package articlemanagementsystem.services.signin;

import articlemanagementsystem.util.AuthenticationService;
import articlemanagementsystem.model.User;
import articlemanagementsystem.exceptions.IllegalPasswordException;
import articlemanagementsystem.exceptions.UserAlreadySignedInException;
import articlemanagementsystem.exceptions.UserNotFoundException;
import articlemanagementsystem.repositories.UserRepository;


public class SignInImpl implements SignInUseCase {
    @Override
    public User signIn(String username, String password) throws UserNotFoundException, UserAlreadySignedInException, IllegalPasswordException {
        UserRepository repository = UserRepository.getInstance();
        User user;

        try {
            user = repository.find("username", "\'" + username + "\'");
        } catch (Exception e) {
            throw new UserNotFoundException("User not found! try again!");
        }


        if(AuthenticationService.getCurrentUser() == user)
            throw new UserAlreadySignedInException("The user is already signed in!");
        if (!password.equals(user.getPassword()))
            throw new IllegalPasswordException("wrong password!");


        AuthenticationService.setCurrentUser(user);
        return user;
    }
}
