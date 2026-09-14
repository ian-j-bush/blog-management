package com.ianjbush.blogmanagement.comments;

import com.ianjbush.blogmanagement.account.Account;
import com.ianjbush.blogmanagement.posts.BlogPost;
import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account commenter;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private BlogPost commentedPost;
}
