package br.com.topicosnewm.petshop.entrypoint.model.usuarioconta;

import br.com.topicosnewm.petshop.dataprovider.model.Plano;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({
        "nomeUsuario",
        "sobrenome",
        "cpfCnpj",
        "email",
        "login",
        "password",
        "tagPlano"
})
public class UsuarioContaRequest {
    private String nomeUsuario;
    private String sobrenome;
    private String cpfCnpj;
    private String email;
    private String login;
    private String password;
    private LocalDateTime dtCriacao;
    private Boolean ativo;
    private Byte tagPlano;
    private Plano plano;
    private LocalDateTime dtExpiracao;
}
