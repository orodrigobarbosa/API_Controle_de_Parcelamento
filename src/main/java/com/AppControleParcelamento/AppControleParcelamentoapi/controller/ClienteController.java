package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor

public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar() {
   
        return Arrays.asList();
    }




}
