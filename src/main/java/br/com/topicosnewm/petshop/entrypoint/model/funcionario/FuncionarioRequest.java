package br.com.topicosnewm.petshop.entrypoint.model.funcionario;

import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@JsonPropertyOrder({
        "nomeFuncionario",
        "profissao",
})
public class FuncionarioRequest {
    @NotBlank
    private String nomeFuncionario;
    @NotBlank
    private String profissao;


}