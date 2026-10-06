package com.ianjbush.blogmanagement.posts;

import com.ianjbush.blogmanagement.account.AccountDTO;
import com.ianjbush.blogmanagement.comments.CommentDTO;
import lombok.Data;

import java.util.Set;

@Data
public class BlogPostDTO {

    private Long id;
    private String title;
    private String content;
    private AccountDTO account;
    private Set<CommentDTO> comments;
}
