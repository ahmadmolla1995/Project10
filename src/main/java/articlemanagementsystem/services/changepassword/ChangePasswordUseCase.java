package articlemanagementsystem.services.changepassword;

import articlemanagementsystem.config.annotation.UseCase;
import articlemanagementsystem.exceptions.*;



@UseCase
public interface ChangePasswordUseCase {
    void changePassword() throws UserSessionNotExistsException, IllegalPasswordException;
}
