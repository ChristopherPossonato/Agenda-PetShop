package br.com.topicosnewm.petshop.entrypoint.model.usuariocriacao;

import java.util.Date;

public record UsuarioCriacaoResponse(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String nomeUsuario,
        String senha,
        Date dtCriacao,
        Boolean ativo
) {
}
