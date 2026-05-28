package com.itau.desafio.repository;

import com.itau.desafio.Dtos.EstatisticaResquest;
import com.itau.desafio.Dtos.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Repository
public class EstatisticaRepository {

    @Autowired
    TransacaoRepository transacaoRepository;


    public EstatisticaResquest calcularEstatisticas(){

        EstatisticaResquest estatisticaResquest =
                new EstatisticaResquest();

        List<TransacaoRequest> transacoes =
                transacaoRepository.calcular60();

        estatisticaResquest.setCount(transacoes.size());

        if(transacoes.isEmpty()){

            estatisticaResquest.setSum(BigDecimal.ZERO);
            estatisticaResquest.setAvg(BigDecimal.ZERO);
            estatisticaResquest.setMin(BigDecimal.ZERO);
            estatisticaResquest.setMax(BigDecimal.ZERO);

            return estatisticaResquest;
        }

        BigDecimal sum = BigDecimal.ZERO;

        BigDecimal min = transacoes.getFirst().getValor();
        BigDecimal max = transacoes.getFirst().getValor();

        for(TransacaoRequest transacaoRequest : transacoes){

            BigDecimal valor = transacaoRequest.getValor();

            sum = sum.add(valor);

            if(valor.compareTo(min) < 0){
                min = valor;
            }

            if(valor.compareTo(max) > 0){
                max = valor;
            }
        }

        estatisticaResquest.setSum(sum);

        BigDecimal avg = sum.divide(
                BigDecimal.valueOf(transacoes.size()),
                2,
                RoundingMode.HALF_UP
        );

        estatisticaResquest.setAvg(avg);

        estatisticaResquest.setMin(min);
        estatisticaResquest.setMax(max);

        return estatisticaResquest;
    }
}
