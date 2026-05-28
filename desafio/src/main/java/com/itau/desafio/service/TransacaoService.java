package com.itau.desafio.service;

import com.itau.desafio.Dtos.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validar(TransacaoRequest transacaoRequest){

        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException ("Erro valor menor que zero");
        }
        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: a data nao corresponde as regras de transacao(datas futuras)");
        }
    }


}
