package com.AppControleParcelamento.AppControleParcelamentoapi.service;

import com.AppControleParcelamento.AppControleParcelamentoapi.repository.ClienteRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.exception.NegocioException;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId){
       return clienteRepository.findById(clienteId).orElseThrow(() -> new NegocioException("Cliente nao encontrado"));
    }

    @Transactional //salvar poderá ser usado tanto para criar cliente como para atualizar
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()) //evitar que clientes sejam cadastrados com mesmo email
                .filter(c -> !c.equals(cliente)) //permite atualizar cliente sem dar duplicidade de email
                .isPresent();

        if (emailEmUso){
            throw new NegocioException("E-mail já em uso por outro usuário");
        }
        return clienteRepository.save(cliente);

    }

    @Transactional
    public void deletar(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
