package com.club27.services;

import com.club27.domain.Jugo;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.JugoRepository;
import com.club27.web.dto.JugoDto;
import com.club27.web.mappers.JugoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class JugoService {

    private final JugoRepository jugoRepository;
    private final JugoMapper jugoMapper;

    @Transactional
    public Jugo getJugo(UUID id) {
        return jugoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Jugo not found"));
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
