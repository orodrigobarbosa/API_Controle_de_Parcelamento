package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.repository.ParcelamentoRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.exception.NegocioException;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Parcelamento;
import com.AppControleParcelamento.AppControleParcelamentoapi.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {

    @Autowired
    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoService parcelamentoService;


    //retornar lista de parcelamentos
    @GetMapping
    public List<Parcelamento> listar() {
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<Parcelamento> buscar(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento){
        return parcelamentoService.cadastrar(parcelamento);
    }



}
