package com.club27.web.mappers;

import com.club27.domain.Pajacyzm;
import com.club27.web.dto.PajacyzmDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PajacyzmMapper {

    PajacyzmDto pajacyzmToDto(Pajacyzm pajacyzm);

    List<PajacyzmDto> mapAll(List<Pajacyzm> list);

}
