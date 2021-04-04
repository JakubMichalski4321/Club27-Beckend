package com.club27.services;

import com.club27.domain.Soundboard;
import com.club27.repositories.SoundboardRepository;
import com.club27.web.dto.SoundboardDto;
import com.club27.web.mappers.SoundboardMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class SoundboardService {
    private final SoundboardRepository soundboardRepository;
    private final SoundboardMapper soundboardMapper;

    public SoundboardService(SoundboardRepository soundboardRepository, SoundboardMapper mapper) {
        this.soundboardRepository = soundboardRepository;
        this.soundboardMapper = mapper;
    }

    @Transactional
    public SoundboardDto getSoundboard(UUID id) {
        var soundboard = soundboardRepository.findById(id);
        return soundboardMapper.soundboardOptionalToDto(soundboard);

    }

    public List<SoundboardDto> getAllSoundboards() {
        var soundboards = soundboardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return soundboardMapper.soundboardListToDto(soundboards);
    }

    @Transactional
    public void submitSoundboard(SoundboardDto soundboardDto) {
        var soundboard = new Soundboard(soundboardDto.getId(), soundboardDto.getTitle(), soundboardDto.getWhoIs(), soundboardDto.getPathToFile());
        soundboardRepository.save(soundboard);
    }
}
