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

public class Pajacyzmy extends BaseEntity {

    private final String content;
    private final String author;

    public Pajacyzmy(UUID id, String content, String author) {
        super(id);
        this.content = content;
        this.author = author;
    }

}
