//Need to refactor as a many to many with posts



//package com.codeup.springblog.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "categories")
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INT(10) UNSIGNED")
//    private long id;
//
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    @OneToMany (mappedBy = "category")
//    private List<Post> posts;
//
//
////    @ManyToOne
////    @JoinColumn (name = "post_id")
////    private Post post;
//
//    public Category() {
//    }
//
//    public Category(long id, String name, Post post) {
//        this.id = id;
//        this.name = name;
//        this.post = post;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }
//}
