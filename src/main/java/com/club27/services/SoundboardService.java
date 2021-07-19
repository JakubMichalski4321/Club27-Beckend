package com.club27.services;

import com.club27.domain.Soundboard;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.SoundboardRepository;
import com.club27.web.dto.SoundboardDto;
import com.club27.web.mappers.SoundboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class SoundboardService {

    private final SoundboardRepository soundboardRepository;
    private final SoundboardMapper soundboardMapper;

    @Transactional
    public Soundboard getSoundboard(UUID id) {
        return soundboardRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Soundboard not found"));

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
        String saveFileDir = "/var/www/html/assets/soundboardSounds/" + file.getOriginalFilename();
        file.transferTo(new File(saveFileDir));
    }

}
