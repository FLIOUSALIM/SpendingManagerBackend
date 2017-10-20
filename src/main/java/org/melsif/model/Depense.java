package org.melsif.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cout;

    private Date date;

    @ManyToOne
    private TypeDepense typeDepense;
}
