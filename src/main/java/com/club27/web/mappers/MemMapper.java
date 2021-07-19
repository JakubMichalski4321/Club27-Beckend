package com.club27.web.mappers;

import com.club27.domain.Comment;
import com.club27.domain.Mem;
import com.club27.web.dto.CommentDto;
import com.club27.web.dto.MemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemMapper {

    MemDto memToDto(Mem mem);
    List<MemDto> mapAll(List<Mem> list);
    CommentDto commentToCommentDto(Comment comment);
    List<CommentDto> mapAllMemeComments(List<Comment> list);

}
