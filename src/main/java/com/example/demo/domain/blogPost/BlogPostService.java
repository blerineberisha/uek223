package com.example.demo.domain.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost getBlogPost(UUID id) {
        return this.blogPostRepository.findById(id).get();
    }

    public List<BlogPost> getAllBlogPosts() {
        return this.blogPostRepository.findAll();
    }

    public List<BlogPost> getAllBlogPostsWithSorting(String field) {
        return this.blogPostRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    /**
     * @param offset   start of the page count, if page count is 0, the second page is page 1, etc.
     * @param pageSize the amount of posts per page
     * @return returns list with paginated posts
     */
    public Page<BlogPost> getAllBlogPostWithPagination(int offset, int pageSize) {
        Page<BlogPost> blogPosts = this.blogPostRepository.findAll(PageRequest.of(offset, pageSize));
        return blogPosts;
    }

    /**
     * @param id id of the blog post that is to be deleted
     */
    public void deleteById(UUID id) {
        this.blogPostRepository.deleteById(id);
    }

    /**
     * @param blogPost blog post that is to be saved
     * @return saves the blog post to the database and returns the blog post
     */
    public BlogPost save(BlogPost blogPost) {
        return this.blogPostRepository.save(blogPost);
    }

    /**
     * @param blogPost the blog post that is to be updated
     * @param id       id of the blog post that is to be updated
     * @return saves the updated blog post to the database and returns the updated blog post
     */
    public BlogPost updateBlogPost(BlogPost blogPost, UUID id) {
        BlogPost old = getBlogPost(id);
        blogPost.setCategory(blogPost.getCategory());
        blogPost.setAuthor(old.getAuthor());
        blogPost.setId(id);
        blogPost.setTitle(blogPost.getTitle());
        blogPost.setText(blogPost.getText());
        final BlogPost updatedBlogPost = blogPostRepository.save(blogPost);
        return updatedBlogPost;
    }
}
