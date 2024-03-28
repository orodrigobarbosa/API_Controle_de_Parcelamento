package com.AppControleParcelamento.AppControleParcelamentoapi.Repository;

import com.AppControleParcelamento.AppControleParcelamentoapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //componente que faz persistência de dados, gerenciada pelo próprio container do Spring
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //entidade que o repositório irá gerenciar

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
}