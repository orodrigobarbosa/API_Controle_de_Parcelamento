package com.AppControleParcelamento.AppControleParcelamentoapi.representationmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ParcelamentoModel { //REPRESENTATION MODEL


    private Long id;
    private String nomeCliente;
    private String descricao;
    private BigDecimal valorTotal;
    private Integer parcelas;
    private OffsetDateTime dataCriacao;


}
