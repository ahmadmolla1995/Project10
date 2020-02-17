package articlemanagementsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity @Table
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String username;

    @Column(unique = true, nullable = false)
    protected String password;

    @Column(unique = true, nullable = false, updatable = false)
    protected String nationalCode;

    @Column(nullable = false, updatable = false)
    protected String birthday;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    protected List<Article> articles;

    @Column(nullable = false)
    protected String userRole;


    public User() {}

    public User(Long id, String username, String password, String nationalCode, String birthday, String userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.articles = new ArrayList<>();
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() { return userRole; }

    public void setRole(String userRole) { this.userRole = userRole; }

    public void setPassword(String password) {
        this.password = password;
    }
}

