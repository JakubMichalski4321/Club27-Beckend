package com.club27.web.mappers;

import com.club27.domain.Comment;
import com.club27.domain.Mem;
import com.club27.web.dto.CommentDto;
import com.club27.web.dto.MemDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope(value = "singleton")
public class MemMapper {

    public MemDto memToDto(Mem mem){
        return new MemDto(
                mem.getId(),
                mem.getTitle(),
                mem.getAuthor(),
                mem.getImagePath(),
                mem.getMemeLikes(),
                mem.getCreatedDate()
        );
    }

    public MemDto memOptionalToDto(Optional<Mem> mem){
        return new MemDto(
                mem.get().getId(),
                mem.get().getTitle(),
                mem.get().getAuthor(),
                mem.get().getImagePath(),
                mem.get().getMemeLikes(),
                mem.get().getCreatedDate()
        );
    }

    public List<MemDto> mapAll(List<Mem> list){
        return list.stream().map(this::memToDto).collect(Collectors.toList());
    }

    private CommentDto commentToCommentDto(Comment comment) {
        return new CommentDto(
                comment.getContent(),
                comment.getAuthor(),
                comment.getCreatedDate()
        );
    }

    public List<CommentDto> mapAllMemeComments(List<Comment> list){
        return list.stream().map(this::commentToCommentDto).collect(Collectors.toList());
    }


}
