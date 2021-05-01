package com.club27.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "mem")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true)
public class Mem extends BaseEntity {

    private String title;
    private String author;
    private String imagePath;
    private int memeLikes;

    @OneToMany(mappedBy = "mem")
    private List<Comment> memeComments;

    public Mem(UUID id, String title, String author, String imagePath, int memeLikes) {
        super(id);
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.memeLikes = memeLikes;
        this.memeComments = new ArrayList<>();
    }

    public Mem(String title, String author, String imagePath, int memeLikes){
        super();
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.memeLikes = memeLikes;
    }
}
