package com.club27.services;

import com.club27.repositories.PajacyzmyRepository;
import org.springframework.stereotype.Service;

@Service
public class PajacyzmyService {
    private final PajacyzmyRepository pajacyzmyRepository;

    public PajacyzmyService(PajacyzmyRepository pajacyzmyRepository) {
        this.pajacyzmyRepository = pajacyzmyRepository;
    }
}
