package com.AppControleParcelamento.AppControleParcelamentoapi.model;

import com.AppControleParcelamento.AppControleParcelamentoapi.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.NonNull;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// Apenas os campos marcados com a anotação @EqualsAndHashCode.Include serão considerados na geração dos métodos equals() e hashCode().
@Getter
@Setter
@Entity

public class Cliente {

    @NotNull (groups = ValidationGroups.ClienteId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @Size (max = 255)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size (max = 20)
    @Column(name = "fone")
    private String telefone;
}
