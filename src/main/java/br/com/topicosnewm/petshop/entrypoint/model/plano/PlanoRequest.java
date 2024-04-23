package br.com.topicosnewm.petshop.entrypoint.model.plano;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "tagPlano",
        "nome",
        "vlPlanoMensal",
        "duracaoEmMeses",
        "limitePerfilUsuario"
})
public class PlanoRequest {
    private Byte tagPlano;
    private String nome;
    private Double vlPlanoMensal;
    private Byte duracaoEmMeses;
    private Byte limitePerfilUsuario;
}