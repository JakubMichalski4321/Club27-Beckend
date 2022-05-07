package com.club27.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Data
@NoArgsConstructor(force = true)
@Entity(name = "soundboard")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Soundboard extends BaseEntity {

    private String title;
    private String whoIs;
    private String pathToFile;

    public Soundboard(String title, String whoIs, String pathToFile) {
        super();
        this.title = title;
        this.whoIs = whoIs;
        this.pathToFile = pathToFile;
    }

    public Soundboard(UUID id, String title, String whoIs, String pathToFile) {
        super(id);
        this.title = title;
        this.whoIs = whoIs;
        this.pathToFile = pathToFile;
    }

}
