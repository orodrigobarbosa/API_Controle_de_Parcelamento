package com.AppControleParcelamento.AppControleParcelamentoapi.controller;

import com.AppControleParcelamento.AppControleParcelamentoapi.Repository.ClienteRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.exception.NegocioException;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;
import com.AppControleParcelamento.AppControleParcelamentoapi.service.ClienteService;

import jakarta.validation.Valid;
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
    private final ClienteService clienteService;

    @Autowired
    //injetar dependencia de forma automática pelo Spring -  uma determinada classe precisa de uma instância de outra classe
    private final ClienteRepository clienteRepository;

    @GetMapping()
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    //return man
    // ager.createQuery("from Cliente", Cliente.class)
    //   .getResultList(); // transforma o resultado em SQL, pegar o resultado e converter em instancias de cliente e retorna lista  de cliente

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId); //Optional é como um container que pode conter algo ou não

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());

        }
        return ResponseEntity.notFound().build(); //caso nao haja o id, retorna codigo http 404
    }



    @ResponseStatus(HttpStatus.CREATED) //CÓDIGO HTTP 201
    @PostMapping
    public Cliente adicionarCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);

    }


    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }


    //--------------------------------------
    /* Deste modo, será necessário colocar o id no payload para buscar o cliente a ser atualizado - o que naõ é o ideal, mas sim na url

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
    public ResponseEntity<Void> excluirPorId(@PathVariable Long clienteId) {  //retorna um response entity sem corpo algum ResponseEntity<Void>
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deletar(clienteId);
        return ResponseEntity.noContent().build(); //código204
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar(NegocioException e){
        return ResponseEntity.badRequest().body(e.getMessage());

    }
}

