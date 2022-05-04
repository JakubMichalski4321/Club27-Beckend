package com.club27.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
@Entity(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity{

    private String name;
    private String pass;

    public User(String name, String pass) {
        super();
        this.name = name;
        this.pass = pass;
    }
}
