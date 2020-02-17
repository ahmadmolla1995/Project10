package articlemanagementsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity @Table
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Article> articleList;


    public Category() {}

    public Category(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.articleList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ID:" + id + "  " + "title:" + title + "  " + "description:" + description;
    }
}

