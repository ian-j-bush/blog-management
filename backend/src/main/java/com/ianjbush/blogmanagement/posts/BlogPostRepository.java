package com.ianjbush.blogmanagement.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {

    Set<BlogPost> findAllByAccountIdOrderByCreatedDateDesc(Long accountId);
}
