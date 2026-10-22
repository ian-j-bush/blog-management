package com.ianjbush.blogmanagement.comments;

import org.junit.jupiter.api.Test;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
public class CommentRepositoryTest {


    @Test
    void testGetCommentByBlogPostId() {
    }

    @Test
    void testGetCommentByBlogPostIdFailsWithInvalidId() {
    }
}
