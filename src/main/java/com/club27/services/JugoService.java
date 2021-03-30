package com.club27.services;

import com.club27.repositories.JugoRepository;
import com.club27.web.dto.JugoDto;
import com.club27.web.mappers.JugoMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugoService {

    private final JugoRepository jugoRepository;
    private final JugoMapper jugoMapper;

    public JugoService(JugoRepository jugoRepository, JugoMapper jugoMapper) {
        this.jugoRepository = jugoRepository;
        this.jugoMapper = jugoMapper;
    }

    public List<JugoDto> getAllJugo() {
        var jugos = jugoRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return jugoMapper.jugoListToDto(jugos);
    }
}
