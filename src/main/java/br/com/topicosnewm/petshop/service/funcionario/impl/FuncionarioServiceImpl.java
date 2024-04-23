package br.com.topicosnewm.petshop.service.funcionario.impl;

import br.com.topicosnewm.petshop.dataprovider.model.Funcionario;
import br.com.topicosnewm.petshop.dataprovider.repository.FuncionarioRepository;
import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import br.com.topicosnewm.petshop.service.funcionario.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public List<FuncionarioDto> listar() {
        return null;
    }

    @Override
    public Optional<FuncionarioDto> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public FuncionarioDto salvar(FuncionarioDto funcionarioDto) {
        var funcionario = mapper.map(funcionarioDto, Funcionario.class);

        var funcionarioSalvo = funcionarioRepository.save(funcionario);

        return mapper.map(funcionarioSalvo, FuncionarioDto.class);
    }


    @Override
    public Long alterar(FuncionarioDto FuncionarioDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
