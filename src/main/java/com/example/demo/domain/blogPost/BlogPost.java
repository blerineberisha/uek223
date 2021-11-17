package com.example.demo.domain.blogPost;

import com.example.demo.domain.appUser.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "author")
    private String author;
    @Column(name = "text")
    private String text;
    @Column(name = "category")
    private String category;

    /**
     *
     * @param id every post has an id that's created with the post request
     * @param title every post has a title that the user can set themselves
     * @param author every post has an author which is the user that sent the request
     * @param text every post has text which the user can write themselves
     * @param category every post has a category so we have labels and a better overview of the posts and
     *                 to group by topic
     */
    public BlogPost(UUID id, String title, String author, String text, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    /*
    * The following code snippet connects the post_id and the user_id in a joint table.
    * This is a many-to-one relationship.
    * --> several blogs can belong to one user, only one user can write one post though.
    * We created this joint table so we can more easily keep track of authors and their posts.
    * */
    @ManyToOne
    @JoinTable(
            name = "users_posts",
            joinColumns = @JoinColumn(
                    name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id")
    )
    private User blogPosts;
}

