package br.com.topicosnewm.petshop.usecase.tabelaservico.impl;

import br.com.topicosnewm.petshop.dataprovider.model.TabelaServico;
import br.com.topicosnewm.petshop.dataprovider.repository.TabelaServicoRepository;
import br.com.topicosnewm.petshop.dto.TabelaServicoDto;
import br.com.topicosnewm.petshop.usecase.tabelaservico.TabelaServicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabelaServicoServiceImpl implements TabelaServicoService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private TabelaServicoRepository tabelaServicoRepository;
    @Override
    public TabelaServicoDto salvar(TabelaServicoDto tabelaServicoDto) {
        var tabelaPrecoServico = mapper.map(tabelaServicoDto, TabelaServico.class);
        // Verifica se já existe um registro com as mesmas características
        if (tabelaServicoRepository.existsByTipoServicoAndPorteAndPacoteAndValorServico(
                tabelaPrecoServico.getTipoServico(),
                tabelaPrecoServico.getPorte(),
                tabelaPrecoServico.getPacote(),
                tabelaPrecoServico.getValorServico())) {
            throw new IllegalArgumentException("Os dados já existem e não podem ser duplicados.");
        }
        var precoServicoSalvo = tabelaServicoRepository.save(tabelaPrecoServico);

        return mapper.map(precoServicoSalvo, TabelaServicoDto.class);
    }
}
