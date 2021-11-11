package com.example.demo.domain.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost getBlogPost(UUID id){
        return this.blogPostRepository.findById(id).get();
    }

    public List<BlogPost> getAllBlogPosts(){
        return this.blogPostRepository.findAll();
    }

    public void deleteById(UUID id){
        this.blogPostRepository.deleteById(id);
    }

    public BlogPost save(BlogPost blogPost){
        return this.blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(BlogPost blogPost, UUID id){
        blogPost.setId(id);
        blogPost.setCategory(blogPost.getCategory());
        blogPost.setTitle(blogPost.getTitle());
        blogPost.setText(blogPost.getText());
        final BlogPost updatedBlogPost = blogPostRepository.save(blogPost);
        return updatedBlogPost;
    }
}
