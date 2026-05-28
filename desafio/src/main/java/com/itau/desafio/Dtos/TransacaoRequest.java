package com.itau.desafio.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest {

    @NotNull(message = "garante que o atributo nao esteja vazio")
    @Positive(message = "garante que o atributo nao seja negativo")
    private BigDecimal valor;

    @NotNull
    private OffsetDateTime dataHora;

}
