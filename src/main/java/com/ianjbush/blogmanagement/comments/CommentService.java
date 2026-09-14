package com.ianjbush.blogmanagement.comments;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ResponseEntity<Comment> deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return ResponseEntity.noContent().build();
    }
}
