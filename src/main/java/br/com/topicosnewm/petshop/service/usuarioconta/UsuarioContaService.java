package br.com.topicosnewm.petshop.service.usuarioconta;

import br.com.topicosnewm.petshop.dto.UsuarioContaDto;

import java.util.Optional;

public interface UsuarioContaService {

    Optional<UsuarioContaDto> buscarPorId(Long id);
    UsuarioContaDto salvar(UsuarioContaDto usuarioContaDto);
    Long alterar(UsuarioContaDto usuarioContaDto);

}
