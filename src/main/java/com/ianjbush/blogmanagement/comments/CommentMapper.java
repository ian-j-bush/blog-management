package com.ianjbush.blogmanagement.comments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

    Comment commentDTOToComment(CommentDTO commentDTO);

    CommentDTO commentToCommentDTO(Comment comment);
}
