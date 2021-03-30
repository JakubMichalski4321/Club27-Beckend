package com.club27.services;

import com.club27.repositories.SoundboardRepository;
import com.club27.web.dto.SoundboardDto;
import com.club27.web.mappers.SoundboardMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoundboardService {
    private final SoundboardRepository soundboardRepository;
    private final SoundboardMapper soundboardMapper;

    public SoundboardService(SoundboardRepository soundboardRepository, SoundboardMapper mapper) {
        this.soundboardRepository = soundboardRepository;
        this.soundboardMapper = mapper;
    }

    public List<SoundboardDto> getAllSoundboards() {
        var soundboards = soundboardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return soundboardMapper.soundboardListToDto(soundboards);
    }
}
