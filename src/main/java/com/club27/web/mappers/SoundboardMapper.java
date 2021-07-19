package com.club27.web.mappers;


import com.club27.domain.Soundboard;
import com.club27.web.dto.SoundboardDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SoundboardMapper {

    List<SoundboardDto> soundboardListToDto(List<Soundboard> soundboardList);

}
