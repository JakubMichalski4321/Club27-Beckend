package com.club27.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
@Entity(name = "diet_statement")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class DietStatement extends BaseEntity {

    private Double weight;
    private String description;

    @ManyToOne
    @JoinColumn(name = "diet_id", nullable = false)
    @JsonIgnore
    private Diet diet;

    public DietStatement(Double weight, String description, Diet diet) {
        super();
        this.weight = weight;
        this.description = description;
        this.diet = diet;
    }

}
