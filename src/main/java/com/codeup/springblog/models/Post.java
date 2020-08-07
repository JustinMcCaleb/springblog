package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    //one-to-many relation to User
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    //one-to-many relation to Comment
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    //many-to-many relationship to Category
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_category",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

    //Constructors ==========================================================
    public Post(){}

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id, String title, String body, User user, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public Post(long id, String title, String body, User user, List<Comment> comments, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
        this.categories = categories;
    }

    //Getters and Setters ==========================================================
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setBody(String body){
        this.body = body;
    }
    public String getBody(){
        return this.body;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
