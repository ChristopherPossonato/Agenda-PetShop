package br.com.topicosnewm.petshop.dto;

import lombok.Data;

@Data
public class PlanoDto {
    private Long id;
    private Byte tagPlano;
    private String nome;
    private Double vlPlanoMensal;
    private Boolean ativo;
    private Byte duracaoEmMeses;
    private Byte limitePerfilUsuario;
}
