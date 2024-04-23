package br.com.topicosnewm.petshop.entrypoint.model.funcionario;

import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@JsonPropertyOrder({
        "nome",
        "profissao",
        "comissao"
})
public class FuncionarioRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String profissao;
    private Double comissao;

}