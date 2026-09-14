package com.ianjbush.blogmanagement.posts;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElseThrow();
    }

    public Set<BlogPost> getBlogPostsByAccountId(Long accountId) {
        return blogPostRepository.findAllByAccountIdOrderByCreatedDateDesc(accountId);
    }
}
