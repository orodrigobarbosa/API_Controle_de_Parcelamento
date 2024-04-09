package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.repository.ParcelamentoRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Parcelamento;
import com.AppControleParcelamento.AppControleParcelamentoapi.representationmodel.ParcelamentoModel;
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
    public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId)
                .map(parcelamento -> {
                    var parcelamentoModel = new ParcelamentoModel();
                    parcelamentoModel.setId(parcelamento.getId());
                    parcelamentoModel.setNomeCliente(parcelamento.getCliente().getNome());
                    parcelamentoModel.setDescricao(parcelamento.getDescricao());
                    parcelamentoModel.setValorTotal(parcelamento.getValorTotal());
                    parcelamentoModel.setParcelas(parcelamento.getQuantidadeParcelas());
                    parcelamentoModel.setDataCriacao(parcelamento.getDataCriacao());


                    return ResponseEntity.ok(parcelamentoModel);


                })
                .orElse(ResponseEntity.notFound().build());

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento){
        return parcelamentoService.cadastrar(parcelamento);
    }



}
