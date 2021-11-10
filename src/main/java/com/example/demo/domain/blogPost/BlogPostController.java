package com.example.demo.domain.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<BlogPost>> findAll() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok().body(blogPosts);
    }

    @PostMapping("/")
    public ResponseEntity<BlogPost> save(@PathVariable UUID id, @RequestBody BlogPost blogPost) {
        return ResponseEntity.ok().body(blogPostService.save(blogPost));
    }
}
