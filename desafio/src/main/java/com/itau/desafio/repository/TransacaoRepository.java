package com.itau.desafio.repository;

import com.itau.desafio.Dtos.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TransacaoRepository {

    List<TransacaoRequest> transacaoList = new ArrayList<>();
    public void salvarNaLista(TransacaoRequest transacao){
        transacaoList.add(transacao);
    }

    public void deletar(){
        transacaoList.clear();
    }

    public TransacaoRequest exibirTransacao(int id){
        return transacaoList.get(id);
    }

    public List<TransacaoRequest> calcular60(){

        OffsetDateTime agora = OffsetDateTime.now();

        return transacaoList.stream()
                .filter(transacao -> {

                    System.out.println(transacao.getDataHora());

                    return transacao.getDataHora()
                            .isAfter(agora.minusSeconds(60));
                })
                .toList();
    }
}
