package com.AppControleParcelamento.AppControleParcelamentoapi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;


@EqualsAndHashCode (onlyExplicitlyIncluded = true) // Apenas os campos marcados com a anotação @EqualsAndHashCode.Include serão considerados na geração dos métodos equals() e hashCode().
@Getter
@Setter
@Entity

public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String email;

    @Column(name = "fone")
    private String telefone;
}
