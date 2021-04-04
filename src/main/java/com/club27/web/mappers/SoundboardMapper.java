package com.club27.web.mappers;


import com.club27.domain.Soundboard;
import com.club27.web.dto.SoundboardDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope(value = "singleton")
public class SoundboardMapper {

    public SoundboardDto soundboardToDto(Soundboard soundboard){
        return new SoundboardDto(
                soundboard.getId(),
                soundboard.getTitle(),
                soundboard.getWhoIs(),
                soundboard.getPathToFile(),
                soundboard.getCreatedDate()
        );
    }

    public SoundboardDto soundboardOptionalToDto(Optional<Soundboard> soundboard) {
        return new SoundboardDto(
                soundboard.get().getId(),
                soundboard.get().getTitle(),
                soundboard.get().getWhoIs(),
                soundboard.get().getPathToFile(),
                soundboard.get().getCreatedDate()
        );
    }

    public List<SoundboardDto> soundboardListToDto(List<Soundboard> soundboardList){
        return soundboardList.stream().map(this::soundboardToDto).collect(Collectors.toList());
    }
}
