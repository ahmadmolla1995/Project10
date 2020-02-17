package articlemanagementsystem;

import articlemanagementsystem.exceptions.CommandNotFoundException;
import articlemanagementsystem.services.changepassword.ChangePasswordImpl;
import articlemanagementsystem.services.changeuserrole.ChangeUserRoleImpl;
import articlemanagementsystem.services.createcategory.CreateCategoryImpl;
import articlemanagementsystem.services.createrole.CreateRoleImpl;
import articlemanagementsystem.services.createtag.CreateTagImpl;
import articlemanagementsystem.services.editarticle.EditArticleImpl;
import articlemanagementsystem.services.publishcancellation.PublishCancellationImpl;
import articlemanagementsystem.services.publishconfirmation.PublishArticleImpl;
import articlemanagementsystem.services.removearticle.RemoveArticleImpl;
import articlemanagementsystem.services.signin.SignInImpl;
import articlemanagementsystem.services.signout.SignOutImpl;
import articlemanagementsystem.services.signup.SignUpImpl;
import articlemanagementsystem.services.viewarticles.ViewArticlesImpl;
import articlemanagementsystem.services.writearticle.CreateArticleImpl;
import articlemanagementsystem.config.databaseconfig.DatabaseInitializer;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initRoleTable();
        DatabaseInitializer.initCategoryTable();
        DatabaseInitializer.initTagTable();
        DatabaseInitializer.signUpAdmin();


        while(true) {
            System.out.print("Enter command:");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();

            try {
                if(command.equalsIgnoreCase("Exit"))
                    break;

                else if (command.equalsIgnoreCase("SignUp")) {
                    System.out.print("username:");
                    String username = scanner.next();
                    System.out.print("national_code:");
                    String nationalCode = scanner.next();
                    System.out.print("user role:");
                    String userRole = scanner.next();
                    System.out.print("birthday:(yyyy/mm/d)");
                    String birthday = scanner.next();
                    SignUpImpl implementer = new SignUpImpl();
                    implementer.signUp(username, nationalCode, birthday, userRole);
                }

                else if (command.equalsIgnoreCase("SignIn")) {
                    System.out.print("username:");
                    String username = scanner.next();
                    System.out.print("password:");
                    String password = scanner.next();
                    SignInImpl implementer = new SignInImpl();
                    implementer.signIn(username, password);
                }

                else if (command.equalsIgnoreCase("ViewArticles")) {
                    ViewArticlesImpl implementer = new ViewArticlesImpl();
                    implementer.viewAll();
                }

                else if (command.equalsIgnoreCase("ViewArticleByWriter")) {
                    System.out.print("writer name:");
                    String writerName = scanner.next();
                    ViewArticlesImpl implementer = new ViewArticlesImpl();
                    implementer.viewByWriterName(writerName);
                }

                else if (command.equalsIgnoreCase("ChangePassword")) {
                    ChangePasswordImpl changePasswordImpl = new ChangePasswordImpl();
                    changePasswordImpl.changePassword();
                }

                else if (command.equalsIgnoreCase("changeUserRole")) {
                    System.out.print("user id:");
                    Long userID = scanner.nextLong();
                    System.out.print("new role:");
                    String newUserRole = scanner.next();
                    ChangeUserRoleImpl implementer = new ChangeUserRoleImpl();
                    implementer.changeRole(userID, newUserRole);
                }

                else if (command.equalsIgnoreCase("WriteArticle")) {
                    CreateArticleImpl createArticleImpl = new CreateArticleImpl();
                    createArticleImpl.write();
                }

                else if (command.equalsIgnoreCase("EditArticle")) {
                    EditArticleImpl implementer = new EditArticleImpl();
                    implementer.edit();
                }

                else if (command.equalsIgnoreCase("RemoveArticle")) {
                    System.out.print("article ID:");
                    Long articleID = scanner.nextLong();
                    RemoveArticleImpl implementer = new RemoveArticleImpl();
                    implementer.remove(articleID);
                }

                else if (command.equalsIgnoreCase("ConfirmPublish")) {
                    System.out.print("article id:");
                    Long articleID = scanner.nextLong();
                    PublishArticleImpl implementer = new PublishArticleImpl();
                    implementer.publishConfirm(articleID);
                }

                else if (command.equalsIgnoreCase("CancelPublish")) {
                    System.out.print("articleID:");
                    Long articleID = scanner.nextLong();
                    PublishCancellationImpl implementer = new PublishCancellationImpl();
                    implementer.publishCancel(articleID);
                }

                else if (command.equalsIgnoreCase("CreateCategory")) {
                    System.out.print("title:");
                    String title = scanner.next();
                    System.out.print("description:");
                    String description = scanner.next();
                    CreateCategoryImpl implementer = new CreateCategoryImpl();
                    implementer.createCategory(title, description);
                }

                else if (command.equalsIgnoreCase("CreateRole")) {
                    System.out.print("role title:");
                    String roleTitle = scanner.next();
                    CreateRoleImpl implementer = new CreateRoleImpl();
                    implementer.createRole(roleTitle);
                }

                else if (command.equalsIgnoreCase("CreateTag")) {
                    System.out.print("title:");
                    String title = scanner.next();
                    CreateTagImpl implementer = new CreateTagImpl();
                    implementer.createTag(title);
                }

                else if (command.equalsIgnoreCase("SignOut")) {
                    SignOutImpl implementer = new SignOutImpl();
                    implementer.signOut();
                }

                else
                    throw new CommandNotFoundException("command not found! try again.");

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

