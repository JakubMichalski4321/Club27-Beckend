package com.club27.web.mappers;

import com.club27.domain.Jugo;
import com.club27.web.dto.JugoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JugoMapper {

    List<JugoDto> jugoListToDto(List<Jugo> jugoList);

}
