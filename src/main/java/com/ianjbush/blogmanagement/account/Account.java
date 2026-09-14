package com.ianjbush.blogmanagement.account;

import com.ianjbush.blogmanagement.comments.Comment;
import com.ianjbush.blogmanagement.posts.BlogPost;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "account")
    private Set<BlogPost> posts;

    @OneToMany(mappedBy = "account")
    private Set<Comment> comments;
}
