package com.ianjbush.blogmanagement.posts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BlogPostController.class)
@ExtendWith(MockitoExtension.class)
public class BlogPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BlogPostService blogPostService;

    @BeforeEach
    void setUp() {

    }
}
