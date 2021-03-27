package com.club27.services;

import com.club27.repositories.JugoRepository;
import org.springframework.stereotype.Service;

@Service
public class JugoService {

    private final JugoRepository jugoRepository;

    public JugoService(JugoRepository jugoRepository) {
        this.jugoRepository = jugoRepository;
    }
}
