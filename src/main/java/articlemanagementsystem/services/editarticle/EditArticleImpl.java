package articlemanagementsystem.services.editarticle;

import articlemanagementsystem.config.annotation.Service;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Article;
import articlemanagementsystem.exceptions.ArticleNotFoundException;
import articlemanagementsystem.repositories.ArticleRepository;
import articlemanagementsystem.util.AuthenticationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;


@Service
public class EditArticleImpl implements EditArticleUseCase {
    @Override
    public void edit() throws ArticleNotFoundException, UserSessionNotExistsException, InvalidCommandException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in! Please log in first");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("writer"))
            throw new InvalidCommandException("Only writer can write an article!");

        Long userID = AuthenticationService.getCurrentUser().getId();
        List<Article> userArticles = ArticleRepository.getInstance().findAll("writer_id", userID.toString());
        if (userArticles.isEmpty())
            throw new ArticleNotFoundException("The Write hasn't written any article yet!");


        System.out.println("Articles\n========================================");
        userArticles.forEach(a -> System.out.println("ID:" + a.getId() + '\t' + "title:" + a.getTitle()));

        System.out.print("article_title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.next();


        for (Article article: userArticles) {
            if (article.getTitle().equals(title)) {
                editTitle(article);
                editBrief(article);
                editContent(article);
                editLastUpdateDate(article);
                ArticleRepository.getInstance().update(article);
                return;
            }
        }
    }

    private void editTitle(Article article) {
        System.out.println("edit article title\n===========================\n1.edit   2.return\n");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        if(command.equals("edit")) {
            System.out.print("new title:");
            String newTitle = scanner.next();
            article.setTitle(newTitle);
        }
    }

    private void editBrief(Article article) {
        System.out.println("edit article brief\n===========================\n1.edit   2.return\n");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        
        if (command.equals("edit")) {
            System.out.print("new brief:");
            String newBrief = scanner.next();
            article.setBrief(newBrief);
        }
    }

    private void editContent(Article article) {
        System.out.println("edit article content\n=========================\n1.edit    2.return");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        if (command.equals("edit")) {
            System.out.print("new content:");
            String newContent = scanner.next();
            article.setContent(newContent);
        }
    }

    private void editLastUpdateDate(Article article) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String lastUpdateDate = dtf.format(LocalDateTime.now());
        article.setLastUpdateDate(lastUpdateDate);
    }
}
