package com.itau.desafio.controller;

import com.itau.desafio.Dtos.TransacaoRequest;
import com.itau.desafio.repository.TransacaoRepository;
import com.itau.desafio.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;


    @Autowired
    private TransacaoService transacaoService;


    @PostMapping
    public ResponseEntity criar(@RequestBody TransacaoRequest transacaoRequest){

        List<TransacaoRequest> transacaoRequestList = new ArrayList<>();

        try {
            transacaoService.validar(transacaoRequest);
            transacaoRepository.salvarNaLista(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("transaçao valida! a transaçao foi criada com sucesso");

        }catch(IllegalArgumentException exception){

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("transaçao é invalida! A transaçao nao contem todas as informaçoes ou contem valores invalidos");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/exibir")
    public ResponseEntity exibir(@RequestParam int id){
        try{
            TransacaoRequest transacaoRequest = transacaoRepository.exibirTransacao(id);
            return ResponseEntity.status(HttpStatus.OK).body(transacaoRequest.toString());
        }catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity deletar(){
        transacaoRepository.deletar();
        return ResponseEntity.status(HttpStatus.OK).body("Lista foi limpa");
    }
}
