package com.ianjbush.blogmanagement.comments;

import com.ianjbush.blogmanagement.config.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController( CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{commentId}")
    public CommentDTO getComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO comment, @PathVariable Long commentId) {
        if( commentService.updateComment(comment, commentId).isEmpty()) {
            throw new NotFoundException("Comment not found");
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long commentId) {
        if(!commentService.deleteComment(commentId)) {
            throw new NotFoundException("Comment not found");
        }
        return ResponseEntity.noContent().build();
    }
}
