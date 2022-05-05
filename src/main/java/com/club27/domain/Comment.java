package com.club27.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity(name = "comment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(force = true)

public class Comment extends BaseEntity{

    private String content;
    private String author;

    public Comment(String content, String author, Mem mem) {
        super();
        this.content = content;
        this.author = author;
        this.mem = mem;
    }

    public Comment(UUID id, String content, String author) {
        super(id);
        this.content = content;
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "mem_id", nullable = false)
    private Mem mem;

}
