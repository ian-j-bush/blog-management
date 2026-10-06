package com.ianjbush.blogmanagement.account;

import com.ianjbush.blogmanagement.comments.CommentDTO;
import com.ianjbush.blogmanagement.posts.BlogPostDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class AccountDTO {

    private String username;
    private String email;
    private String role;
    private LocalDateTime creationDate;
    private String accountStatus;
    private Set<BlogPostDTO> posts;
    private Set<CommentDTO> comments;
}
