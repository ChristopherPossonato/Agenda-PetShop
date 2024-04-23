package br.com.topicosnewm.petshop.service.animal.impl;

import br.com.topicosnewm.petshop.dataprovider.repository.AnimalRepository;
import br.com.topicosnewm.petshop.dto.AnimalDto;
import br.com.topicosnewm.petshop.service.animal.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animaisRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AnimalDto salvar(AnimalDto animalDto) {

        return null;
    }
}
