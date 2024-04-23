package br.com.topicosnewm.petshop.service.agendamento.impl;

import br.com.topicosnewm.petshop.dataprovider.repository.AgendamentoRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.AnimalRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.FuncionarioRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.TutorRepository;
import br.com.topicosnewm.petshop.dto.AgendamentoDto;
import br.com.topicosnewm.petshop.service.agendamento.AgendamentoService;
import br.com.topicosnewm.petshop.service.animal.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public AgendamentoDto agendar(AgendamentoDto agendamentoDto) {



        return null;
    }
}
