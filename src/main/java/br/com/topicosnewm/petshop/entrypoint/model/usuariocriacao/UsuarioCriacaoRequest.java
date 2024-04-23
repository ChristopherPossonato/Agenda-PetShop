package br.com.topicosnewm.petshop.entrypoint.model.usuariocriacao;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({
        "nome",
        "sobrenome",
        "email",
        "login",
        "password",
        "tagPlano"
})
public class UsuarioCriacaoRequest {
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
