package com.ianjbush.blogmanagement.comments;

import com.ianjbush.blogmanagement.account.Account;
import com.ianjbush.blogmanagement.posts.BlogPost;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentBody;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private BlogPost post;
}
