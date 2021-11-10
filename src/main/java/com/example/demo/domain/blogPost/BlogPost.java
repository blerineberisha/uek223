package com.example.demo.domain.blogPost;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="text")
    private String text;
    @Column(name="category")
    private String category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<BlogPost> posts) {
        this.posts = posts;
    }

    @ManyToMany
    @JoinTable(
            name = "users_posts",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "post_id", referencedColumnName = "id"))
    private Set<BlogPost> posts;
}
