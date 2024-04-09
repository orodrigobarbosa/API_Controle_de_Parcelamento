package com.AppControleParcelamento.AppControleParcelamentoapi.service;

import com.AppControleParcelamento.AppControleParcelamentoapi.repository.ParcelamentoRepository;
import com.AppControleParcelamento.AppControleParcelamentoapi.exception.NegocioException;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;
import com.AppControleParcelamento.AppControleParcelamentoapi.model.Parcelamento;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    @Autowired
    private final ParcelamentoRepository parcelamentoRepository;
    private final ClienteService clienteService;

    @Transactional
    public Parcelamento cadastrar(Parcelamento novoParcelamento) {
        if (novoParcelamento.getId() != 0) {
            throw new NegocioException("O parcelamento a ser criado não deve possuir um código.");
        }
        // Implemente o restante da lógica para cadastrar o parcelamento aqui


        Cliente cliente = clienteService.buscar(novoParcelamento.getCliente().getId());

        novoParcelamento.setCliente((cliente));


        novoParcelamento.setDataCriacao(OffsetDateTime.now());
        return parcelamentoRepository.save(novoParcelamento);
    }
}
