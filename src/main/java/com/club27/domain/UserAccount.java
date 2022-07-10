package com.club27.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "user_account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(force = true)
public class UserAccount extends BaseEntity {

    @ManyToMany
    @JoinTable(
            name = "user_depts",
            joinColumns = @JoinColumn(name = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "dept_id"))
    List<Dept> userDepts;
    private String name;
    private String pass;

    public UserAccount(UUID id, String name, String pass) {
        super(id);
        this.name = name;
        this.pass = pass;
    }

    public UserAccount(String name, String pass) {
        super();
        this.name = name;
        this.pass = pass;
    }
}
