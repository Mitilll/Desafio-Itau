package com.itau.desafio.controller;

import com.itau.desafio.Dtos.EstatisticaResquest;
import com.itau.desafio.repository.EstatisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaRepository estatisticaRepository;

    @GetMapping()
    public ResponseEntity exibirEstatisticas(){
        try {
            EstatisticaResquest estatisticas = estatisticaRepository.calcularEstatisticas();

            return ResponseEntity.status(HttpStatus.OK).body(estatisticas);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nao foi possivel exibir estatisticcas");
        }
    }

}
