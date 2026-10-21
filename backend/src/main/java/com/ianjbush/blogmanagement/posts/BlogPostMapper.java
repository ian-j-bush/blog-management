package com.ianjbush.blogmanagement.posts;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BlogPostMapper {

    BlogPost blogPostDTOToBlogPost(BlogPostDTO blogPostDTO);

    BlogPostDTO blogPostToBlogPostDTO(BlogPost blogPost);
}
