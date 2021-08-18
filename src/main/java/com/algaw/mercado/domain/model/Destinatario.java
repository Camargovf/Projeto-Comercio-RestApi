package com.algaw.mercado.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable // tem capacidade de ser usada em outra entidade.
public class Destinatario {

    //Primeiro roda e cria no dados - depois refresh com datasource do banco. (destinatario_nome)

    @NotBlank
    @Column(name = "destinatario_nome")
    private String nome;

    @NotBlank
    @Column(name = "destinatario_logradouro")
    private String logradouro;

    @NotBlank
    @Column(name = "destinatario_numero")
    private String numero;

    @NotBlank
    @Column(name = "destinatario_complemento")
    private String complemento;

    @NotBlank
    @Column(name = "destinatario_bairro")
    private String bairro;


}
