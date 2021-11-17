package com.example.demo.domain.blogPost;

import com.example.demo.domain.security.BlogPostSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     *
     * @return returns list of all blog posts; unsorted, unfiltered.
     */
    @GetMapping("")
    public List<BlogPost> findAll() {
        return this.blogPostService.getAllBlogPosts();
    }

    /**
     *
     * @param field fields of BlogPost, i.e. ID, title, author, etc.
     * @return returns sorted blog posts
     */
    @GetMapping("/sort/{field}")
    public List<BlogPost> findAllWithSorting(@PathVariable String field) {
        return this.blogPostService.getAllBlogPostsWithSorting(field);
    }

    /**
     *
     * @param offset start of the page count, i.e. if offset is set to 3, the page count starts at 3
     *               so page 4 would actually be the second page, etc.
     * @param pageSize amount of records on one page
     * @return
     */
    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<BlogPost> findAllWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<BlogPost> blogPosts = blogPostService.getAllBlogPostWithPagination(offset, pageSize);
        return blogPosts;
    }

    /**
     *
     * @param blogPost blog post that is to be saved
     * @return saves blog post to database and returns that blogpost
     */
    @PostMapping("/post/")
    public BlogPost save(@RequestBody BlogPost blogPost) {
        blogPost.setAuthor(BlogPostSecurity.getCurrentUsername());
        return this.blogPostService.save(blogPost);
    }

    /**
     *
     * @param id id of post that is to be updated
     * @param blogPost blogpost that is to be updated
     * @return returns updated blog post
     */
    @PutMapping("/search/{id}")
    public BlogPost updateBlogPost(@PathVariable("id") UUID id, @RequestBody BlogPost blogPost) {
        return this.blogPostService.updateBlogPost(blogPost, id);
    }

    /**
     *
     * @param id id of the blog post that is to be deleted
     */
    @DeleteMapping("/delete/{id}")
    public void deleteBlogPost(@PathVariable("id") UUID id) {
        this.blogPostService.deleteById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BlogPost getSinglePost(@PathVariable("id") UUID id) {
        return this.blogPostService.getBlogPost(id);
    }

}
