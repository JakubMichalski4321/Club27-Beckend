package com.club27.domain;

import com.club27.web.dto.PajacyzmDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor(force = true)
@Data

public class Pajacyzm extends BaseEntity {

    private final String content;
    private final String author;

    public Pajacyzm(UUID id, String content, String author) {
        super(id);
        this.content = content;
        this.author = author;
    }

}
