package br.com.topicosnewm.petshop.service.funcionario;

import br.com.topicosnewm.petshop.dto.FuncionarioDto;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    List<FuncionarioDto> listar();
    Optional<FuncionarioDto> buscarPorId(Long id);
    FuncionarioDto salvar(FuncionarioDto funcionarioDto);
    Long alterar(FuncionarioDto FuncionarioDto);
    void excluir(Long id);
}
