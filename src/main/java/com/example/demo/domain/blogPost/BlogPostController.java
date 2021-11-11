package com.example.demo.domain.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.FetchType;
import java.util.List;
import java.util.UUID;


@RequestMapping("/blogpost")
@RestController
public class BlogPostController {
    private BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("")
    public List<BlogPost> findAll() {
        return this.blogPostService.getAllBlogPosts();
    }

    @PostMapping("/")
    //@PreAuthorize("hasRole('USER or ADMIN')")
    public BlogPost save(@RequestBody BlogPost blogPost) {
        return this.blogPostService.save(blogPost);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable UUID id, @RequestBody BlogPost blogPost) {
        return this.blogPostService.updateBlogPost(blogPost, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable UUID id){
        this.blogPostService.deleteById(id);
    }

}
