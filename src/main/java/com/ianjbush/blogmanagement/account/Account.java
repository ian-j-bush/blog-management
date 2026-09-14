package com.ianjbush.blogmanagement.account;

import com.ianjbush.blogmanagement.comments.Comment;
import com.ianjbush.blogmanagement.posts.BlogPost;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
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

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private String accountStatus;

    @OneToMany(mappedBy = "account")
    private Set<BlogPost> posts;

    @OneToMany(mappedBy = "account")
    private Set<Comment> comments;
}
