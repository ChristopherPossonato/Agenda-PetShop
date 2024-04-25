package br.com.topicosnewm.petshop.usecase.plano.impl;

import br.com.topicosnewm.petshop.dataprovider.model.Plano;
import br.com.topicosnewm.petshop.dataprovider.repository.PlanoRepository;
import br.com.topicosnewm.petshop.dto.PlanoDto;
import br.com.topicosnewm.petshop.usecase.plano.PlanoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoServiceImpl implements PlanoService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PlanoRepository planoRepository;

    @Override
    public PlanoDto salvar(PlanoDto planoDto) {
        var plano = mapper.map(planoDto, Plano.class);
        var planoSalvo = planoRepository.save(plano);
        return mapper.map(planoSalvo, PlanoDto.class);
    }
}
