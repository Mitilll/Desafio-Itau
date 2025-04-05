package desafioItauSpring.example.Springboot.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionRequest {

    @NotNull

    private double valor;

    @NotNull
    private OffsetDateTime dataHOra;

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHOra() {
        return dataHOra;
    }
}
