package com.ianjbush.blogmanagement.posts;

import com.ianjbush.blogmanagement.comments.Comment;
import com.ianjbush.blogmanagement.comments.CommentDTO;
import com.ianjbush.blogmanagement.comments.CommentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class BlogPostController {

    private final BlogPostService blogPostService;
    private final CommentService commentService;

    public BlogPostController(BlogPostService blogPostService, CommentService commentService) {
        this.blogPostService = blogPostService;
        this.commentService = commentService;
    }

    @GetMapping()
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{postId}")
    public BlogPostDTO getBlogPost(@PathVariable Long postId) throws Exception {
        return blogPostService.getBlogPostById(postId).orElseThrow(Exception::new);
    }

    @GetMapping("/{postId}/comments")
    public List<CommentDTO> getAllComments(@PathVariable Long postId) {
        return commentService.getCommentsOnBlogPost(postId);
    }

    @PostMapping
    public ResponseEntity<BlogPostDTO> createBlogPost(@RequestBody BlogPostDTO blogPost){
        BlogPostDTO newPost =  blogPostService.createBlogPost(blogPost);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/posts/" + newPost.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        commentService.postNewComment(comment);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/posts/" + postId + "/" + comment.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long postId, @RequestBody BlogPost blogPost) throws Exception {
        if(blogPostService.updateBlogPost(postId, blogPost).isEmpty()) {
            throw new Exception();
        }


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<BlogPost> deleteBlogPost(@PathVariable Long postId) throws Exception {
        if(!blogPostService.deleteBlogPost(postId)) {
            throw new Exception("Blog Post Not Found: (Implement Further)");
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
