package br.com.topicosnewm.petshop.service.usuariocriacao.impl;

import br.com.topicosnewm.petshop.dataprovider.model.Plano;
import br.com.topicosnewm.petshop.dataprovider.model.UsuarioCriacao;
import br.com.topicosnewm.petshop.dataprovider.repository.PlanoRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.UsuarioCriacaoRepository;
import br.com.topicosnewm.petshop.dto.UsuarioCriacaoDto;
import br.com.topicosnewm.petshop.service.usuariocriacao.UsuarioCriacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;
@Service
public class UsuarioCriacaoServiceImpl implements UsuarioCriacaoService {
    @Autowired
    private UsuarioCriacaoRepository usuarioCriacaoRepository;
    @Autowired
    private PlanoRepository planoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Optional<UsuarioCriacaoDto> buscarPorId(Long id) {
        var usuarioCriacao = usuarioCriacaoRepository.getReferenceById(id);
        if (usuarioCriacao != null) {
            UsuarioCriacaoDto obj = mapper.map(usuarioCriacao, UsuarioCriacaoDto.class);

            return Optional.of(obj);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public UsuarioCriacaoDto salvar(UsuarioCriacaoDto usuarioCriacaoDto) {
        //Entidade UsuarioCriacao
        var usuarioCriacao = this.mapper.map(usuarioCriacaoDto, UsuarioCriacao.class);

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

        var usuarioCriado = usuarioCriacaoRepository.save(usuarioCriacao);


        return mapper.map(usuarioCriado, UsuarioCriacaoDto.class);
    }
    @Override
    public Long alterar(UsuarioCriacaoDto usuarioCriacaoDto) {

        if (usuarioCriacaoDto.getId() == null) {
            throw new IllegalArgumentException("ID do usuario não pode ser nulo para atualização");
        }

        var usuarioExistente = usuarioCriacaoRepository.getReferenceById(usuarioCriacaoDto.getId());


        // Atualize os campos relevantes da tarefa existente com os valores do DTO
        mapper.map(usuarioCriacaoDto, usuarioExistente);

        UsuarioCriacao usuarioAtualizada = usuarioCriacaoRepository.save(usuarioExistente);

        return usuarioAtualizada.getId();
    }
}
