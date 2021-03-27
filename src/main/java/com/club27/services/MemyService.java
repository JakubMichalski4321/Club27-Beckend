package com.club27.services;

import com.club27.repositories.MemyRepository;
import org.springframework.stereotype.Service;

@Service
public class MemyService {
    private final MemyRepository memyRepository;

    public MemyService(MemyRepository memyRepository) {
        this.memyRepository = memyRepository;
    }
}
