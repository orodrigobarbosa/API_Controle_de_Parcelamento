package com.AppControleParcelamento.AppControleParcelamentoapi.model;

import com.AppControleParcelamento.AppControleParcelamentoapi.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Valid //validacao em cascata - vai requerer que seja passado todas as outras propriedades de cliente(nome, email, telefone), ***mas nao faz sentido. Por isso, utilizaremos o Validation Groups abaixo.
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valorTotal;

    @NotNull
    @Positive
    @Max(value = 12)
    private Integer quantidadeParcelas;

    private LocalDateTime dataCriacao;
}
