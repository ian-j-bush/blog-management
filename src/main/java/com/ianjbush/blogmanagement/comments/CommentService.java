package com.ianjbush.blogmanagement.comments;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow();
    }

    public Comment updateComment(Comment comment, Long commentId) {
        return null;
    }

    public ResponseEntity<Comment> deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return ResponseEntity.noContent().build();
    }

    public Comment postNewComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsOnBlogPost(Long postId) {
        //TODO: Adjust repository to create method
        return new ArrayList<>();
    }
}
