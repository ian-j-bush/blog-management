package com.ianjbush.blogmanagement.posts;

import org.springframework.stereotype.Service;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
}
