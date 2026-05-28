package com.itau.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estatistica {

    private int count;
    private BigDecimal sum;
    private double avg;
    private double min;
    private double max;



}
