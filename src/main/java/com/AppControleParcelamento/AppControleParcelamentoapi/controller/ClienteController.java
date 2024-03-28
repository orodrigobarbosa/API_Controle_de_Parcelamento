package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.Repository.ClienteRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
public class ClienteController {

  /*  @PersistenceContext //instancia manager
    private EntityManager manager; //USADA PARA FAZER OPERACOES COM AS ENTIDADES DO BANCO DE DADOS.
   */


    @Autowired //injetar dependencia de forma automática pelo Spring -  uma determinada classe precisa de uma instância de outra classe
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    //return manager.createQuery("from Cliente", Cliente.class)
    //   .getResultList(); // transforma o resultado em SQL, pegar o resultado e converter em instancias de cliente e retorna lista  de cliente


}
