package com.club27.services;

import com.club27.domain.Jugo;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.JugoRepository;
import com.club27.web.dto.JugoDto;
import com.club27.web.dto.JugosWithCounterDto;
import com.club27.web.mappers.JugoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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

    public Jugo getJugo(UUID id) {
        return jugoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Jugo not found"));
    }

    public JugosWithCounterDto getJugos(int pageNumberInt, int numberPerPageInt) {
        var jugos = jugoRepository.findAll(PageRequest.of(pageNumberInt, numberPerPageInt, Sort.by(Sort.Direction.DESC, "createdDate")));
        var counter = jugoRepository.count();
        return new JugosWithCounterDto(jugoMapper.jugoListToDto(jugos.getContent()), counter);
    }

    @Transactional
    public void submitJugo(JugoDto jugoDto) {
        var jugo = new Jugo(jugoDto.title(), convertVideoUrl(jugoDto.videoURL()), null, 0);
        jugoRepository.save(jugo);
    }

    private String convertVideoUrl(String url) {
        if (url.contains("youtube.com") || url.contains("youtu.be")) {
            int startIndex = url.indexOf("?v=");
            if (startIndex == -1) {
                startIndex = url.indexOf("/v/") + 3;
            }
            int endIndex = url.indexOf("&", startIndex);
            if (endIndex == -1) {
                endIndex = url.length();
            }
            String videoId = url.substring(startIndex + 3, endIndex);
            return "https://www.youtube.com/embed/" + videoId;
        } else {
            return url;
        }
    }

    @Transactional
    public void giveOneLike(UUID id) {
        var jugo = jugoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Jugo not found!"));
        jugo.setVideoLikes(jugo.getVideoLikes() + 1);
    }
}
