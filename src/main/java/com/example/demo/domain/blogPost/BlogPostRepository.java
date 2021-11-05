package com.example.demo.domain.blogPost;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogPostRepository  extends JpaRepository<BlogPost, UUID> {
    
}
