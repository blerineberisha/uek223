package com.example.demo.domain.blogPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    @ManyToMany
    @JoinTable(
            name = "users_posts",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "post_id", referencedColumnName = "id"))
    private Set<BlogPost> posts;
}
