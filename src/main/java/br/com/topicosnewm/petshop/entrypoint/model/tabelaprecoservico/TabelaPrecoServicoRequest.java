package br.com.topicosnewm.petshop.entrypoint.model.tabelaprecoservico;

import br.com.topicosnewm.petshop.dataprovider.model.Pacote;
import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "tipoServico",
        "porte",
        "pacote",
        "valor"
})
public class TabelaPrecoServicoRequest {

    @NotBlank
    private String tipoServico;
    @Enumerated(EnumType.STRING)
    private Porte porte;
    @Enumerated(EnumType.STRING)
    private Pacote pacote;

    private Double valor;

}
