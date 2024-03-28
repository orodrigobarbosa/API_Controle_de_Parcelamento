package com.AppControleParcelamento.AppControleParcelamentoapi.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;


public class Parcelamento {

    String descricao;
    BigDecimal valorTotal;
    Integer quantidadeParcelas;
    Date dataCriacao;
}
