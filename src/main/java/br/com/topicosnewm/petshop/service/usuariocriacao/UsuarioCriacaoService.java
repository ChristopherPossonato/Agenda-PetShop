package br.com.topicosnewm.petshop.service.usuariocriacao;

import br.com.topicosnewm.petshop.dto.UsuarioCriacaoDto;

import java.util.Optional;

public interface UsuarioCriacaoService {

    Optional<UsuarioCriacaoDto> buscarPorId(Long id);
    UsuarioCriacaoDto salvar(UsuarioCriacaoDto usuarioCriacaoDto);
    Long alterar(UsuarioCriacaoDto usuarioCriacaoDto);

}
