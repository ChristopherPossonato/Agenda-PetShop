package br.com.topicosnewm.petshop.service.tabelaprecoservico.impl;

import br.com.topicosnewm.petshop.dataprovider.model.TabelaPrecoServico;
import br.com.topicosnewm.petshop.dataprovider.repository.TabelaPrecoServicoRepository;
import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import br.com.topicosnewm.petshop.dto.TabelaPrecoServicoDto;
import br.com.topicosnewm.petshop.service.tabelaprecoservico.TabelaPrecoServicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabelaPrecoServicoServiceImpl implements TabelaPrecoServicoService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private TabelaPrecoServicoRepository tabelaPrecoServicoRepository;
    @Override
    public TabelaPrecoServicoDto salvar(TabelaPrecoServicoDto tabelaPrecoServicoDto) {
        var tabelaPrecoServico = mapper.map(tabelaPrecoServicoDto, TabelaPrecoServico.class);
        // Verifica se já existe um registro com as mesmas características
        if (tabelaPrecoServicoRepository.existsByTipoServicoAndPorteAndPacoteAndValor(
                tabelaPrecoServico.getTipoServico(),
                tabelaPrecoServico.getPorte(),
                tabelaPrecoServico.getPacote(),
                tabelaPrecoServico.getValor())) {
            throw new IllegalArgumentException("Os dados já existem e não podem ser duplicados.");
        }
        var precoServicoSalvo = tabelaPrecoServicoRepository.save(tabelaPrecoServico);

        return mapper.map(precoServicoSalvo, TabelaPrecoServicoDto.class);
    }
}
