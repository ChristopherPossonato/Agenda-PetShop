package br.com.topicosnewm.petshop.service.usuarioconta.impl;

import br.com.topicosnewm.petshop.dataprovider.model.UsuarioConta;
import br.com.topicosnewm.petshop.dataprovider.repository.PlanoRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.UsuarioContaRepository;
import br.com.topicosnewm.petshop.dto.UsuarioContaDto;
import br.com.topicosnewm.petshop.service.usuarioconta.UsuarioContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class UsuarioContaServiceImpl implements UsuarioContaService {
    @Autowired
    private UsuarioContaRepository usuarioContaRepository;
    @Autowired
    private PlanoRepository planoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Optional<UsuarioContaDto> buscarPorId(Long id) {
        var usuarioCriacao = usuarioContaRepository.getReferenceById(id);
        if (usuarioCriacao != null) {
            UsuarioContaDto obj = mapper.map(usuarioCriacao, UsuarioContaDto.class);

            return Optional.of(obj);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public UsuarioContaDto criarConta(UsuarioContaDto usuarioContaDto) {

        var usuarioCriacao = this.mapper.map(usuarioContaDto, UsuarioConta.class);



        // Entidade Plano
        var tagPlano = planoRepository.getReferenceByTagPlano(usuarioCriacao.getTagPlano());

        if (tagPlano.getId() != null && tagPlano.getTagPlano().equals(usuarioCriacao.getTagPlano())) {
            usuarioCriacao.setPlano(tagPlano);
        }

        usuarioCriacao.setDtCriacao(LocalDateTime.now());
        usuarioCriacao.setAtivo(true);
        String senhaCodificada = passwordEncoder.encode(usuarioCriacao.getPassword());
        usuarioCriacao.setPassword(senhaCodificada);
        var dtExpiracao = usuarioCriacao.getDtCriacao().plusMonths(tagPlano.getDuracaoEmMeses());
        usuarioCriacao.setDtExpiracao(dtExpiracao);

        var usuarioCriado = usuarioContaRepository.save(usuarioCriacao);


        return mapper.map(usuarioCriado, UsuarioContaDto.class);
    }
    @Override
    public Long alterar(UsuarioContaDto usuarioContaDto) {

        if (usuarioContaDto.getId() == null) {
            throw new IllegalArgumentException("ID do usuario não pode ser nulo para atualização");
        }

        var usuarioExistente = usuarioContaRepository.getReferenceById(usuarioContaDto.getId());


        // Atualize os campos relevantes da tarefa existente com os valores do DTO
        mapper.map(usuarioContaDto, usuarioExistente);

        UsuarioConta usuarioAtualizada = usuarioContaRepository.save(usuarioExistente);

        return usuarioAtualizada.getId();
    }
}
