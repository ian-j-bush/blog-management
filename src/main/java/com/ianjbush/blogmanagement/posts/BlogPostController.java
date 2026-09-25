package com.ianjbush.blogmanagement.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/posts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{postId}")
    public BlogPost getBlogPost(@PathVariable Long postId) {
        return blogPostService.getBlogPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BlogPost> updateBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.updateBlogPost(blogPost);
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost){
        return ResponseEntity.ok(blogPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<BlogPost> deleteBlogPost(@PathVariable Long postId){
        return blogPostService.deleteBlogPost(postId);
    }
}
