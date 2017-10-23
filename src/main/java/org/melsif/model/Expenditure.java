package org.melsif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int cout;

    private Date date;

    @ManyToOne
    private ExpenditureType expenditureType;
}
