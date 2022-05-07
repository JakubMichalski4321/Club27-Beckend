package com.club27.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Data
@Entity(name = "pajacyzm")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(force = true)
public class Pajacyzm extends BaseEntity {

    private String content;
    private String author;

    public Pajacyzm(String content, String author) {
        super();
        this.content = content;
        this.author = author;
    }

    public Pajacyzm(UUID id, String content, String author) {
        super(id);
        this.content = content;
        this.author = author;
    }
}
