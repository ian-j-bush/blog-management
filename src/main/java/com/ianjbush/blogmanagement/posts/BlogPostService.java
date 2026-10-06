package com.ianjbush.blogmanagement.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;

    public BlogPostService(BlogPostRepository blogPostRepository, BlogPostMapper blogPostMapper) {
        this.blogPostRepository = blogPostRepository;
        this.blogPostMapper = blogPostMapper;
    }

    public BlogPostDTO getBlogPostById(Long id) {
        return blogPostMapper.blogPostToBlogPostDTO(blogPostRepository.findById(id).orElse(null));
    }

    public Set<BlogPostDTO> getBlogPostsByAccountId(Long accountId) {
        Set<BlogPost> blogPosts = blogPostRepository.findAllByAccountIdOrderByCreatedDateDesc(accountId);

        return blogPosts.stream().map(blogPostMapper::blogPostToBlogPostDTO).collect(Collectors.toSet());
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public ResponseEntity<BlogPost> updateBlogPost(BlogPost blogPost) {
        //TODO: Create method
        return null;
    }

    public ResponseEntity<BlogPost> deleteBlogPost(Long postId) {
        blogPostRepository.deleteById(postId);

        return ResponseEntity.ok().build();
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
}
