package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Plano;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UsuarioContaDto {
        private Long id;
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