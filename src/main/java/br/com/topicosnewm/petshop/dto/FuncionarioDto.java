package br.com.topicosnewm.petshop.dto;

import lombok.Data;

@Data
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String profissao;
    private Double comissao;
}

