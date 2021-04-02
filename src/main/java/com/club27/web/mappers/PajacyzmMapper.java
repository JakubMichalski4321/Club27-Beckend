package com.club27.web.mappers;

import com.club27.domain.Pajacyzm;
import com.club27.web.dto.PajacyzmDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope(value = "singleton")
public class PajacyzmMapper {

    public PajacyzmDto pajacyzmToDto(Pajacyzm pajacyzm){
        return new PajacyzmDto(
                pajacyzm.getId(),
                pajacyzm.getContent(),
                pajacyzm.getAuthor(),
                pajacyzm.getCreatedDate()
        );
    }

    public PajacyzmDto pajacyzmOptionalToDto(Optional<Pajacyzm> pajacyzm){
        return new PajacyzmDto(
                pajacyzm.get().getId(),
                pajacyzm.get().getContent(),
                pajacyzm.get().getAuthor(),
                pajacyzm.get().getCreatedDate()
        );
    }

    public List<PajacyzmDto> mapAll(List<Pajacyzm> list){
        return list.stream().map(this::pajacyzmToDto).collect(Collectors.toList());
    }

}
