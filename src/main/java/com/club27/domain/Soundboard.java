package com.club27.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor(force = true)
@Data

public class Soundboard extends BaseEntity{
    private final String title;
    private final String whoIs;
    private final String pathToFile;

    public Soundboard(UUID id, String title, String whoIs, String pathToFile) {
        super(id);
        this.title = title;
        this.whoIs = whoIs;
        this.pathToFile = pathToFile;
    }

}
