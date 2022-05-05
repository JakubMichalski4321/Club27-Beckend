package com.club27.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "user_account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(force = true)
public class UserAccount extends BaseEntity{

    private String name;
    private String pass;

    @ManyToMany
    @JoinTable(
            name = "user_depts",
            joinColumns = @JoinColumn(name = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "dept_id"))
    List<Dept> userDepts;

    public UserAccount(UUID id, String name, String pass) {
        super(id);
        this.name = name;
        this.pass = pass;
    }

    public UserAccount(String name, String pass){
        super();
        this.name = name;
        this.pass = pass;
    }
}
