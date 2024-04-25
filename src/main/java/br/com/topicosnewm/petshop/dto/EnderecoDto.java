package br.com.topicosnewm.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
        private String logradouro;

        private String numero;

        private String complemento;

        private String bairro;

        private String bloco;

        private String apartamento;

}
