package com.ianjbush.blogmanagement.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public ResponseEntity<BlogPost> updateBlogPost(BlogPost blogPost) {
        //TODO: Create method
        return null;
    }

    public ResponseEntity<BlogPost> deleteBlogPost(Long postId) {
        blogPostRepository.deleteById(postId);

        return ResponseEntity.ok().build();
    }
}
