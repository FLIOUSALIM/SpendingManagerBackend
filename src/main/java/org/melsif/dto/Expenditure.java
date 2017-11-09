package org.melsif.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expenditure {

    private int id;

    private int cout;

    private String date;

    private String type;
}
