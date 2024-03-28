package com.AppControleParcelamento.AppControleParcelamentoapi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.Setter;



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
