package com.club27.web.mappers;

import com.club27.domain.Jugo;
import com.club27.web.dto.JugoDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope(value = "singleton")
public class JugoMapper {

    public JugoDto jugoToDto(Jugo jugo){
        return new JugoDto(
                jugo.getTitle(),
                jugo.getVideoURL(),
                jugo.getVideoComment(),
                jugo.getVideoLikes(),
                jugo.getCreatedDate()
        );
    }

    public JugoDto JugoOptionalToDto(Optional<Jugo> jugo){
        return new JugoDto(
                jugo.get().getTitle(),
                jugo.get().getVideoURL(),
                jugo.get().getVideoComment(),
                jugo.get().getVideoLikes(),
                jugo.get().getCreatedDate()
        );
    }

    public List<JugoDto> jugoListToDto(List<Jugo> jugoList){
        return jugoList.stream().map(this::jugoToDto).collect(Collectors.toList());
    }

}
