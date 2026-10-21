package com.ianjbush.blogmanagement.posts;

import com.ianjbush.blogmanagement.account.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    void testSaveBlogPost() {
        BlogPost newPost = new BlogPost();
        newPost.setTitle("New Title");
        newPost.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        newPost.setCreatedDate(LocalDateTime.now());
        newPost.setAccount(new Account());
        blogPostRepository.save(newPost);
    }
}
