package com.example.demo.domain.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("/blogpost")
@RestController
@Transactional(isolation = Isolation.REPEATABLE_READ)
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

    @GetMapping("/{field}")
    public List<BlogPost> findAllWithSorting(@PathVariable String field) {
        return this.blogPostService.getAllBlogPostsWithSorting(field);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<BlogPost> findAllWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<BlogPost> blogPosts = blogPostService.getAllBlogPostWithPagination(offset, pageSize);
        return blogPosts;
    }

    @PostMapping("/")
    public BlogPost save(@RequestBody BlogPost blogPost) {
        return this.blogPostService.save(blogPost);
    }

    @PutMapping("/search/{id}")
    public BlogPost updateBlogPost(@PathVariable UUID id, @RequestBody BlogPost blogPost) {
        return this.blogPostService.updateBlogPost(blogPost, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBlogPost(@PathVariable UUID id) {
        this.blogPostService.deleteById(id);
    }

}
