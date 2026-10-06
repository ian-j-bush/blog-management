package com.ianjbush.blogmanagement.account;

import com.ianjbush.blogmanagement.posts.BlogPost;
import com.ianjbush.blogmanagement.posts.BlogPostDTO;
import com.ianjbush.blogmanagement.posts.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class AccountController {

    private final AccountService accountService;
    private final BlogPostService blogPostService;

    public AccountController(AccountService accountService, BlogPostService blogPostService) {
        this.accountService = accountService;
        this.blogPostService = blogPostService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/{id}/posts")
    public Set<BlogPostDTO> getPosts(@PathVariable Long id) {
        return blogPostService.getBlogPostsByAccountId(id);
    }


}
