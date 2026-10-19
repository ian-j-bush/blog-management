package com.ianjbush.blogmanagement.comments;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDTO getComment(Long commentId) {
        Comment foundComment = commentRepository.findById(commentId).orElseThrow();
        return commentMapper.commentToCommentDTO(foundComment);
    }

    public Optional<CommentDTO> updateComment(CommentDTO comment, Long commentId) {
        AtomicReference<Optional<CommentDTO>> commentReference = new AtomicReference<>();

        commentRepository.findById(commentId).ifPresentOrElse(foundComment -> {
            foundComment.setCommentBody(comment.getCommentBody());
            commentReference.set(Optional.of(commentMapper.commentToCommentDTO(foundComment)));
        }, () -> {
            commentReference.set(Optional.empty());
        });

        return commentReference.get();
    }

    public Boolean deleteComment(Long commentId) {
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
            return true;
        }

        return false;
    }

    public CommentDTO postNewComment(CommentDTO comment) {
        return commentMapper.commentToCommentDTO(commentRepository.save(commentMapper.commentDTOToComment(comment)));
    }

    public List<CommentDTO> getCommentsOnBlogPost(Long postId) {
        return commentRepository.getCommentsByPostId(postId).stream().map(commentMapper::commentToCommentDTO).toList();
    }
}
