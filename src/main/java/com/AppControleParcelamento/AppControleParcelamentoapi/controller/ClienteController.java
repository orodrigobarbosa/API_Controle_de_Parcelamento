package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor

public class ClienteController {

    @PersistenceContext //instancia a variável manager
    private EntityManager manager; //USADA PARA FAZER OPERACOES COM AS ENTIDADES DO BANCO DE DADOS.


    @GetMapping("/clientes")
    public List<Cliente> listar() {
    return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }




}
