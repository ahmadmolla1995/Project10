package articlemanagementsystem.services.writearticle;

import articlemanagementsystem.exceptions.CategoryNotFoundException;
import articlemanagementsystem.exceptions.InvalidCommandException;
import articlemanagementsystem.exceptions.TagNotFoundException;
import articlemanagementsystem.exceptions.UserSessionNotExistsException;
import articlemanagementsystem.model.Article;
import articlemanagementsystem.model.Category;
import articlemanagementsystem.model.Tag;
import articlemanagementsystem.model.User;
import articlemanagementsystem.repositories.ArticleRepository;
import articlemanagementsystem.repositories.CategoryRepository;
import articlemanagementsystem.repositories.TagRepository;
import articlemanagementsystem.util.AuthenticationService;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



public class CreateArticleImpl implements CreateArticleUseCase {
    @Override
    public void write() throws NoResultException, UserSessionNotExistsException, InvalidCommandException, CategoryNotFoundException, TagNotFoundException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserSessionNotExistsException("The user is not logged in!");
        if (!AuthenticationService.getCurrentUser().getUserRole().equals("writer"))
            throw new InvalidCommandException("Only writer can write an article!");


        Scanner scanner = new Scanner(System.in);
        System.out.print("article title:");
        String title = scanner.next();
        System.out.print("brief:");
        String brief = scanner.next();
        System.out.print("content:");
        String content = scanner.next();
        String createDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());

        ArticleRepository articleRepository = ArticleRepository.getInstance();
        Article article = new Article(null, title, brief, content, createDate);

        User writer = AuthenticationService.getCurrentUser();
        Category category = specifyArticleCategory();
        List<Tag> tags = specifyArticleTags();

        article.setWriter(writer);
        article.setCategory(category);
        article.setTags(tags);
        articleRepository.save(article);
    }

    private static Category specifyArticleCategory() throws CategoryNotFoundException {
        List<Category> categories = CategoryRepository.getInstance().findAll();
        System.out.println("\n\ncategories\n=============================");
        categories.forEach(c -> System.out.println(c.toString()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("category title:");
        String categoryTitle = scanner.next();

        try {
            return CategoryRepository.getInstance().find("title", "\'" + categoryTitle + "\'");
        } catch (Exception e) {
            throw new CategoryNotFoundException("category not found!");
        }
    }

    private static List<Tag> specifyArticleTags() throws TagNotFoundException {
        List<Tag> entities = TagRepository.getInstance().findAll();
        System.out.println("\n\ntags\n=================================");
        entities.forEach(e -> System.out.println(e.toString()));

        Scanner scanner = new Scanner(System.in);
        List<Tag> tags = new ArrayList<>();

        while(true) {
            System.out.print("tag title:");
            String tagTitle = scanner.next();
            if (tagTitle.equals("exit"))
                break;

            Tag tag = TagRepository.getInstance().find("title", "\'" + tagTitle + "\'");
            tags.add(tag);
        }

        return tags;
    }
}


