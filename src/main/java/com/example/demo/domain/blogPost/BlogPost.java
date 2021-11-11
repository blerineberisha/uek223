package com.example.demo.domain.blogPost;

import com.example.demo.domain.appUser.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID user_id;
    @Column(name = "text")
    private String text;
    @Column(name = "category")
    private String category;

    public BlogPost(UUID id, String title, UUID user_id, String text, String category) {
        this.id = id;
        this.title = title;
        this.user_id = user_id;
        this.text = text;
        this.category = category;
    }

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

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
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

//    @OneToOne
//    @JoinTable(
//            name = "users_posts",
//            joinColumns = @JoinColumn(
//                    name = "post_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id")
//    )
//    private User blogPosts;
}

