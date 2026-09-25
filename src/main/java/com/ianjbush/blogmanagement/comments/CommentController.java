package com.ianjbush.blogmanagement.comments;

import com.ianjbush.blogmanagement.account.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController( CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Account> addComment(@RequestBody Comment comment) {
        return null;
    }
}
