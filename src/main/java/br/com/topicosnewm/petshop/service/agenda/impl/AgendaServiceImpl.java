package br.com.topicosnewm.petshop.service.agenda.impl;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import br.com.topicosnewm.petshop.dataprovider.repository.*;
import br.com.topicosnewm.petshop.dto.AgendaDto;
import br.com.topicosnewm.petshop.dto.AnimalDto;
import br.com.topicosnewm.petshop.dto.EnderecoDto;
import br.com.topicosnewm.petshop.dto.TutorDto;
import br.com.topicosnewm.petshop.service.agenda.AgendaService;
import br.com.topicosnewm.petshop.utils.DataExpiracaoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorCompletionService;

@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private TabelaServicoRepository tabelaServicoRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public AgendaDto agendar(AgendaDto agendaDto) {

        Tutor objTutor = salvarTutor(agendaDto);

        var tutorSalvo = tutorRepository.save(objTutor);

        salvarAnimal(agendaDto, tutorSalvo);

        var agenda = this.mapper.map(agendaDto, Agenda.class);


        TabelaServico tabelaServico = tabelaServicoRepository.findByTabelaServico(
                agenda.getPacote()
                ,agenda.getTutor().getAnimais().getFirst().getPorte()
                ,"Banho"
        );
        agenda.setTabelaServico(tabelaServico);
        agenda.setTutor(tutorSalvo);
        agenda.setStatusAgendamento(StatusAgendamento.PENDENTE);
        agenda.setStatus(true);
        agenda.setDataVencimento(DataExpiracaoUtil.calcularDataExpiracao(agenda.getDataHora(), agenda.getPacote()));

        var agendar = agendaRepository.save(agenda);

        return mapper.map(agendar, AgendaDto.class);
    }

    private void salvarAnimal(AgendaDto agendaDto, Tutor tutor) {
        var agenda = mapper.map(agendaDto, Agenda.class);

        agenda.getTutor().getAnimais().forEach(a -> {
            var animalDto = AnimalDto.builder()
                    .nomeAnimal(a.getNomeAnimal())
                    .raca(a.getRaca())
                    .porte(a.getPorte())
                    .tutor(tutor)
                    .build();
            var salvarAnimal = mapper.map(animalDto, Animal.class);
           animalRepository.save(salvarAnimal);
        });

    }


    public Tutor salvarTutor(AgendaDto agendaDto) {
        var bloco = "N/I";
        var apartamento = "N/I";
        var complemento = "N/I";
        if (agendaDto.getTutor() != null && agendaDto.getTutor().getEndereco() != null) {
            bloco = agendaDto.getTutor().getEndereco().getBloco();
            apartamento = agendaDto.getTutor().getEndereco().getApartamento();
            agendaDto.getTutor().getEndereco().getComplemento();
        }
        var endereco = Endereco.builder()
                .logradouro(agendaDto.getTutor().getEndereco().getLogradouro())
                .bairro(agendaDto.getTutor().getEndereco().getBairro())
                .complemento(complemento == null ? complemento = "N/I" : complemento)
                .numero(agendaDto.getTutor().getEndereco().getNumero())
                .bloco(bloco == null ? bloco = "N/I" : bloco)
                .apartamento(apartamento == null ? apartamento = "N/I" : apartamento)
                .build();

        var tutor = Tutor.builder()
                .nomeTutor(agendaDto.getTutor().getNomeTutor())
                .telefone(agendaDto.getTutor().getTelefone())
                .endereco(endereco)
                .animais(new ArrayList<>())
                .build();

        return tutor;
    }
}


