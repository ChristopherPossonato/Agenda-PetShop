package br.com.topicosnewm.petshop.dataprovider.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
@Builder
public class Endereco {
    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;

    private String complemento;

    private String bairro;

    private String bloco;

    private String apartamento;
}
