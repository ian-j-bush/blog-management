package com.ianjbush.blogmanagement.posts;

import com.ianjbush.blogmanagement.account.Account;
import com.ianjbush.blogmanagement.comments.Comment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
}
