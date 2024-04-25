package br.com.topicosnewm.petshop.usecase.usuarioconta;

import br.com.topicosnewm.petshop.dto.UsuarioContaDto;

import java.util.Optional;

public interface UsuarioContaService {

    Optional<UsuarioContaDto> buscarPorId(Long id);
    UsuarioContaDto criarConta(UsuarioContaDto usuarioContaDto);
    Long alterar(UsuarioContaDto usuarioContaDto);

}
