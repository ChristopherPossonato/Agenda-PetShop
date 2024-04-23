package br.com.topicosnewm.petshop.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UsuarioContaDto {
        private Long id;
        private String nome;
        private String sobrenome;
        private String email;
        private String login;
        private String password;
        private LocalDate dtCriacao;
        private Boolean ativo;
        private Byte tagPlano;
        private LocalDateTime dtExpiracao;

}
