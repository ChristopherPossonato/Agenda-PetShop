package br.com.topicosnewm.petshop.entrypoint.model.usuarioconta;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonPropertyOrder({
        "nome",
        "sobrenome",
        "email",
        "login",
        "password",
        "tagPlano"
})
public class UsuarioContaRequest {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String login;
    private String password;
    private LocalDate dtCriacao;
    private Boolean ativo;
    private Byte tagPlano;
}
