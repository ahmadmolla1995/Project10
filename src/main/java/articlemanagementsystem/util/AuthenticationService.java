package articlemanagementsystem.util;

import articlemanagementsystem.model.User;


public class AuthenticationService {
    private static User currentUser = null;

    private AuthenticationService() {}


    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser (User user) {
        currentUser = user;
    }

    public static void removeCurrentUser() {
        currentUser = null;
    }

}
