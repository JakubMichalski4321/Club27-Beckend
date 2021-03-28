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

public class Mem extends BaseEntity {

    private final String title;
    private final String author;
    private final String imagePath;
    private final int memeLikes;

    public Mem(UUID id, String title, String author, String imagePath, int memeLikes) {
        super(id);
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.memeLikes = memeLikes;
    }
}
