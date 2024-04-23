package br.com.topicosnewm.petshop.service.agenda.impl;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import br.com.topicosnewm.petshop.dataprovider.repository.AgendaRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.AnimalRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.FuncionarioRepository;
import br.com.topicosnewm.petshop.dataprovider.repository.TutorRepository;
import br.com.topicosnewm.petshop.dto.AgendaDto;
import br.com.topicosnewm.petshop.service.agenda.AgendaService;
import br.com.topicosnewm.petshop.utils.DataExpiracaoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private ModelMapper mapper;

    @Override
    public AgendaDto agendar(AgendaDto agendaDto) {
        var agenda = this.mapper.map(agendaDto, Agenda.class);

        var bloco = agenda.getTutor().getEndereco().getBloco();
        bloco = bloco == null ? bloco = "N/I" : bloco;
        var apartamento = agenda.getTutor().getEndereco().getApartamento();
        apartamento = apartamento == null ? apartamento = "N/I" : apartamento;

        var endereco = Endereco.builder()
                .logradouro(agenda.getTutor().getEndereco().getLogradouro())
                .bairro(agenda.getTutor().getEndereco().getBairro())
                .numero(agenda.getTutor().getEndereco().getNumero())
                .bloco(bloco)
                .apartamento(apartamento)
                .build();

        var tutor = Tutor.builder()
                .nomeTutor(agenda.getTutor().getNomeTutor())
                .telefone(agenda.getTutor().getTelefone())
                .endereco(endereco)
                .animais(new ArrayList<>()) // Inicializa uma nova lista para os animais do tutor
                .build();

        // Salva o tutor no banco de dados
        var tutorSalvo = tutorRepository.save(tutor);

        // Salva os animais associados ao novo tutor
        agenda.getTutor().getAnimais().forEach(a -> {
            var salvarAnimal = Animal.builder()
                    .nomeAnimal(a.getNomeAnimal())
                    .raca(a.getRaca())
                    .porte(a.getPorte())
                    .tutor(tutorSalvo) // Usa o tutor recém-salvo para associar aos animais
                    .build();
            animalRepository.save(salvarAnimal);
        });

        // Atualiza o tutor na agenda para usar o tutor salvo
        agenda.setTutor(tutorSalvo);

        agenda.setStatusAgendamento(StatusAgendamento.PENDENTE);
        agenda.setStatus(true);
        agenda.setDataVencimento(DataExpiracaoUtil.calcularDataExpiracao(agenda.getDataHora(), agenda.getTabelaServico().getPacote()));
        agendaRepository.save(agenda);

        return mapper.map(agenda, AgendaDto.class);
    }
}
