package desafioItauSpring.example.Springboot.controller;


import desafioItauSpring.example.Springboot.dto.TransactionRequest;
import desafioItauSpring.example.Springboot.model.Transaction;
import desafioItauSpring.example.Springboot.services.TransectionServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

/*
aldkalskd
 */
@RestController
@RequestMapping("/transacao")
public class TransactionControler {

    private final TransectionServices transectionServices;

    public TransactionControler (TransectionServices transectionServices){
        this.transectionServices = transectionServices;
    }

    @PostMapping
    public ResponseEntity<Void> createTrasaction(@Valid @RequestBody TransactionRequest request){
        if (request.getDataHOra().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
            return ResponseEntity.unprocessableEntity().build();
        }
        transectionServices.addTransaciton(new Transaction(request.getValor(), request.getDataHOra()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public  ResponseEntity<Void> clearTrasactions(){
        transectionServices.clearTransactions();
        return ResponseEntity.ok().build();
    }



}
