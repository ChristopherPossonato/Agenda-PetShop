package br.com.topicosnewm.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDto {
    private Long id;
    private String nomeFuncionario;
    private String profissao;

}

