package articlemanagementsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Table
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String brief;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String createDate;

    @Column(nullable = false)
    private Boolean isPublished;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany(targetEntity = Tag.class)
    private List<Tag> tags;


    private String lastUpdateDate;
    private String publishDate;


    public Article() {}

    public Article(Long id, String title, String brief, String content, String createDate) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = createDate;
        this.publishDate = null;
        this.isPublished = false;
        this.writer = new User();
        this.category = new Category();
        this.tags = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBrief() {
        return brief;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String newContent) { this.content = newContent; }

    public void setBrief(String newBrief) {
        this.brief = newBrief;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public void setCategory(Category category) { this.category = category; }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setTags(List<Tag> tags) { this.tags = tags; }

    public void publishConfirm() {
        this.isPublished = true;
    }

    public void publishCancel() {
        this.isPublished = false;
    }


    @Override
    public String toString() {
        return "ID:" + id +
                "  title:" + title +
                "  brief:" + brief +
                "  content:" + content +
                "  createDate:" + createDate +
                "  lastUpdateDate:" + lastUpdateDate +
                "  publishDate:" + publishDate +
                "  isPublished:" + isPublished + '\n';
    }
}

