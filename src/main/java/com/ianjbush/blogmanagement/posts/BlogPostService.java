package com.ianjbush.blogmanagement.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;

    public BlogPostService(BlogPostRepository blogPostRepository, BlogPostMapper blogPostMapper) {
        this.blogPostRepository = blogPostRepository;
        this.blogPostMapper = blogPostMapper;
    }

    public Optional<BlogPostDTO> getBlogPostById(Long id) {
        return Optional.ofNullable(blogPostMapper.blogPostToBlogPostDTO(blogPostRepository.findById(id).orElse(null)));
    }

    public Set<BlogPostDTO> getBlogPostsByAccountId(Long accountId) {
        Set<BlogPost> blogPosts = blogPostRepository.findAllByAccountIdOrderByCreatedDateDesc(accountId);

        return blogPosts.stream().map(blogPostMapper::blogPostToBlogPostDTO).collect(Collectors.toSet());
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPostDTO> updateBlogPost(Long id, BlogPost blogPost) {
        //TODO: Create method
        AtomicReference<Optional<BlogPostDTO>> optionalBlogPost = new AtomicReference<>();

        blogPostRepository.findById(id).ifPresentOrElse(foundBlogPost -> {
            foundBlogPost.setTitle(blogPost.getTitle());
            foundBlogPost.setContent(blogPost.getContent());

            optionalBlogPost.set(Optional.of(blogPostMapper.blogPostToBlogPostDTO(blogPostRepository.save(foundBlogPost))));
        }, () -> {
            optionalBlogPost.set(Optional.empty());
        });

        return optionalBlogPost.get();
    }

    public Boolean deleteBlogPost(Long postId) {
        if( blogPostRepository.existsById(postId)) {
            blogPostRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    public BlogPostDTO createBlogPost(BlogPostDTO blogPost) {
        return blogPostMapper.blogPostToBlogPostDTO(blogPostRepository.save(blogPostMapper.blogPostDTOToBlogPost(blogPost)));
    }
}
