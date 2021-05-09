package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    private int id;
    private String date; //example: yyyy/MM/dd
    private String description;
    private Pet pet;
}
