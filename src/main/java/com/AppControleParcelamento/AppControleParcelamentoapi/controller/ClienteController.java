package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.Repository.ClienteRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

  /*  @PersistenceContext //instancia manager
    private EntityManager manager; //USADA PARA FAZER OPERACOES COM AS ENTIDADES DO BANCO DE DADOS.
   */


    @Autowired
    //injetar dependencia de forma automática pelo Spring -  uma determinada classe precisa de uma instância de outra classe
    private ClienteRepository clienteRepository;

    @GetMapping()
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    //return manager.createQuery("from Cliente", Cliente.class)
    //   .getResultList(); // transforma o resultado em SQL, pegar o resultado e converter em instancias de cliente e retorna lista  de cliente

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());

        }
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED) //CÓDIGO HTTP 201
    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }


    //--------------------------------------
    /* Deste modo, será necessário colocar o id no payload - o que naõ é o ideal, mas sim na url

    exemplo: {"id": "3",
    "nome": "Manu Barbosa",
    "email": "manu@gmail.com",
    "telefone": "9877777777"}

    @PutMapping
    public Cliente atualizarCliente(@RequestBody Cliente cliente){
        if (cliente.getId()==null) {
            throw new RuntimeException("Cliente sem ID");
        }
        return clienteRepository.save(cliente);

        } */


    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluirPorId(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return  ResponseEntity.noContent().build();
    }
}

