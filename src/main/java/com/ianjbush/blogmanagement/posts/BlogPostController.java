package com.ianjbush.blogmanagement.posts;

import com.ianjbush.blogmanagement.comments.Comment;
import com.ianjbush.blogmanagement.comments.CommentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/posts")
public class BlogPostController {

    private final BlogPostService blogPostService;
    private final CommentService commentService;

    public BlogPostController(BlogPostService blogPostService, CommentService commentService) {
        this.blogPostService = blogPostService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{postId}")
    public BlogPost getBlogPost(@PathVariable Long postId) {
        return blogPostService.getBlogPostById(postId);
    }

    @GetMapping("/{postId}/comments")
    public List<Comment> getAllComments(@PathVariable Long postId) {
        return commentService.getCommentsOnBlogPost(postId);
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost){
        BlogPost newPost =  blogPostService.createBlogPost(blogPost);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/posts/" + newPost.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        commentService.postNewComment(comment);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BlogPost> updateBlogPost(@RequestBody BlogPost blogPost,  @PathVariable Long postId) {
        return blogPostService.updateBlogPost(blogPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<BlogPost> deleteBlogPost(@PathVariable Long postId){
        return blogPostService.deleteBlogPost(postId);
    }
}
