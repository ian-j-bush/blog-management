package com.ianjbush.blogmanagement.comments;

import com.ianjbush.blogmanagement.account.AccountDTO;
import com.ianjbush.blogmanagement.posts.BlogPostDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private Long id;
    private String commentBody;
    private LocalDateTime creationDate;
    private AccountDTO account;
    private BlogPostDTO post;
}
