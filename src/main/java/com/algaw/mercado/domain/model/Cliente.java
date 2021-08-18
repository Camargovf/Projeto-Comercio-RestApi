package com.algaw.mercado.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)  //verificar id
@Setter
@Getter
@Entity // associar com os nomes da tabela persistir
public class Cliente  {

//    @NotNull(groups = ValidationGroups.ClienteId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Estrategia auto-increment o banco de dados resolve)
    private Long id;

    @NotBlank // não nulo e vazio
    @Size(max = 60) //sql 60
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "telefone")
    private String telefone;


}
