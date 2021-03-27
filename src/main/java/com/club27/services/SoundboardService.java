package com.club27.services;

import com.club27.repositories.SoundboardRepository;
import org.springframework.stereotype.Service;

@Service
public class SoundboardService {
    private final SoundboardRepository soundboardRepository;

    public SoundboardService(SoundboardRepository soundboardRepository) {
        this.soundboardRepository = soundboardRepository;
    }
}
