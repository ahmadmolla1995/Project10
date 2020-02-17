package articlemanagementsystem.services.signout;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.UserAlreadySignedOutException;


@UseCase
public interface SignOutUseCase {
    void signOut() throws UserAlreadySignedOutException;
}
