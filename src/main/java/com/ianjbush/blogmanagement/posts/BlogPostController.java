package com.ianjbush.blogmanagement.posts;

import org.springframework.web.bind.annotation.RestController;

@RestController("/posts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
}
