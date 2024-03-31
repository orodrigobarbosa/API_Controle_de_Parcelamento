package com.AppControleParcelamento.AppControleParcelamentoapi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @ManyToOne
   // @JoinColumn(name = "cliente_id")//identifica a coluna cliente_id na tabela Parcelamento para obter o cliente a partir de um parcelamento buscando pelo id na tabela Cliente
   // mas nao é necessário fazer o uso, porque por padrao ele ja entende que é o cliente id
    private Cliente cliente;

    private String descricao;
    private BigDecimal valorTotal;
    private Integer quantidadeParcelas;
    private LocalDateTime dataCriacao;
}
