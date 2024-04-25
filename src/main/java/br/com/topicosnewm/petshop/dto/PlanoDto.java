package br.com.topicosnewm.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanoDto {
    private Long id;
    private Byte tagPlano;
    private String nome;
    private Double vlPlanoMensal;
    private Boolean ativo;
    private Byte duracaoEmMeses;
    private Byte limitePerfilUsuario;
}
