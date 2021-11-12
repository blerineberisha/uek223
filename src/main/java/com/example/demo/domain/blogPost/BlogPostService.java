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
    public BlogPostService(BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost getBlogPost(UUID id){
        return this.blogPostRepository.findById(id).get();
    }

    public List<BlogPost> getAllBlogPosts(){
        return this.blogPostRepository.findAll();
    }

    public List<BlogPost> getAllBlogPostsWithSorting(String field){
        return this.blogPostRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<BlogPost> getAllBlogPostWithPagination(int offset, int pageSize){
        Page<BlogPost> blogPosts = this.blogPostRepository.findAll(PageRequest.of(offset, pageSize));
        return blogPosts;
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
