package com.club27.services;

import antlr.StringUtils;
import com.club27.domain.Soundboard;
import com.club27.repositories.SoundboardRepository;
import com.club27.web.dto.SoundboardDto;
import com.club27.web.mappers.SoundboardMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    public void submitSoundboardSound(MultipartFile file) throws IOException {
        String saveFileDir = "C:\\Users\\1234c\\Desktop\\club27\\club27-frontend\\src\\assets\\" + file.getOriginalFilename();
        file.transferTo(new File(saveFileDir));
    }

}
