package articlemanagementsystem.model;


public final class Admin extends User {
    private static String username = "database_admin";
    private static String password = "secret";
    private static final String userRole = "admin";
    private static final String nationalCode = "00145023659";
    private static final String birthday = "1374/09/12";


    public static User getInstance() {
        return new User(null, username, password, nationalCode, birthday ,userRole);
    }
}
