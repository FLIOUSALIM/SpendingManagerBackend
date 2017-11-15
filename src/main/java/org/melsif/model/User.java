package org.melsif.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lastname;

    private String firstname;

    private int budget;

    private String username;

    private String password;

    @OneToMany
    private List<Expenditure> expenditures;
}
