package com.example.demo.domain.blogPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "blog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String author;
    private String text;
    private String category;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_posts",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "post_id", referencedColumnName = "id"))
    private Set<BlogPost> posts;


    public BlogPost(Object o, String stuff, String blablablablablabla, String blablablablabla, String funny_stuff) {
    }
}
