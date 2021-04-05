package com.club27.services;

import com.club27.domain.Jugo;
import com.club27.repositories.JugoRepository;
import com.club27.web.dto.JugoDto;
import com.club27.web.mappers.JugoMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class JugoService {

    private final JugoRepository jugoRepository;
    private final JugoMapper jugoMapper;

    public JugoService(JugoRepository jugoRepository, JugoMapper jugoMapper) {
        this.jugoRepository = jugoRepository;
        this.jugoMapper = jugoMapper;
    }

    @Transactional
    public JugoDto getJugo(UUID id) {
        var jugo = jugoRepository.findById(id);
        return jugoMapper.JugoOptionalToDto(jugo);
    }

    public List<JugoDto> getAllJugo() {
        var jugos = jugoRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return jugoMapper.jugoListToDto(jugos);
    }

    @Transactional
    public void submitJugo(JugoDto jugoDto) {
        var jugo = new Jugo(jugoDto.getTitle(), jugoDto.getVideoURL(), jugoDto.getVideoComment(), jugoDto.getVideoLikes());
        jugoRepository.save(jugo);
    }
}
