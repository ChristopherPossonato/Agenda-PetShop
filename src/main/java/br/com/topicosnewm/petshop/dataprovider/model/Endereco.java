package br.com.topicosnewm.petshop.dataprovider.model;

import br.com.topicosnewm.petshop.dto.EnderecoDto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
