package articlemanagementsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Table
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private List<Article> articleList;


    public Tag() {}

    public Tag(Long id, String title) {
        this.id = id;
        this.title = title;
        this.articleList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "ID:" + id + "  " + "title:" + title;
    }
}
