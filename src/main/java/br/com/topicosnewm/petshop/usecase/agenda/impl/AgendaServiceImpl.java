package br.com.topicosnewm.petshop.usecase.agenda.impl;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import br.com.topicosnewm.petshop.dataprovider.repository.*;
import br.com.topicosnewm.petshop.dto.*;
import br.com.topicosnewm.petshop.exception.CustomException;
import br.com.topicosnewm.petshop.exception.ExceptionMessage;
import br.com.topicosnewm.petshop.usecase.agenda.AgendaService;
import br.com.topicosnewm.petshop.utils.DataExpiracaoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        TutorDto tutorDto = salvarTutor(agendaDto);
        var tutor = mapper.map(tutorDto, Tutor.class);
        var tutorSalvo = tutorRepository.save(tutor);

        salvarAnimal(agendaDto, tutorSalvo);

        TabelaServico tabelaServico = buscarServico(agendaDto);

        var agenda = this.mapper.map(agendaDto, Agenda.class);
        agenda.setTabelaServico(tabelaServico);
        agenda.setTutor(tutorSalvo);
        agenda.setStatusAgendamento(StatusAgendamento.PENDENTE);
        agenda.setStatus(true);
        agenda.setDataVencimento(DataExpiracaoUtil.calcularDataExpiracao(agenda.getDataHora(), agenda.getPacote()));

        var agendar = agendaRepository.save(agenda);

        return mapper.map(agendar, AgendaDto.class);
    }

    private TabelaServico buscarServico(AgendaDto agendaDto) {

        var tabelaServico = tabelaServicoRepository.findByTabelaServico(
                agendaDto.getPacote()
                ,agendaDto.getTutor().getAnimais().getFirst().getPorte()
                ,agendaDto.getTipoServico());
        if(tabelaServico.getId() == null) {
            throw new CustomException(ExceptionMessage.SERVICO_NAO_ENCONTRADO.getMessage());
        }

        return tabelaServico;
    }

    private void salvarAnimal(AgendaDto agendaDto, Tutor tutor) {
        var tutorExiste = tutorRepository.getReferenceById(tutor.getId_tutor());

        if(tutorExiste != null) {
            agendaDto.getTutor().getAnimais().forEach(a -> {
                var animalDto = AnimalDto.builder()
                        .nomeAnimal(a.getNomeAnimal())
                        .raca(a.getRaca())
                        .porte(a.getPorte())
                        .tutor(tutor)
                        .build();
                var salvarAnimal = mapper.map(animalDto, Animal.class);

                animalRepository.save(salvarAnimal);
            });
        }else {
            throw new CustomException(ExceptionMessage.TUTOR_NAO_LOCALIZADA.getMessage());
        }

    }


    private TutorDto salvarTutor(AgendaDto agendaDto) {

        var nomeTutor = agendaDto.getTutor().getNomeTutor();
        var telefone = agendaDto.getTutor().getTelefone();

        if((nomeTutor == null || nomeTutor.isEmpty() || nomeTutor.isBlank())
                || (telefone == null || telefone.isEmpty() || telefone.isBlank())) {
            throw new CustomException(ExceptionMessage.TUTOR_NAO_LOCALIZADA.getMessage());
        }

        EnderecoDto enderecoDto = criarEndereco(agendaDto);

        var tutorDto = TutorDto.builder()
                .nomeTutor(nomeTutor)
                .telefone(telefone)
                .endereco(enderecoDto)
                .animais(new ArrayList<>())
                .build();

        return tutorDto;
    }

    private EnderecoDto criarEndereco(AgendaDto agendaDto) {

        var logradouro = agendaDto.getTutor().getEndereco().getLogradouro();
        var numero = agendaDto.getTutor().getEndereco().getNumero();
        var bloco = agendaDto.getTutor().getEndereco().getBloco();
        var apartamento = agendaDto.getTutor().getEndereco().getApartamento();
        var complemento = agendaDto.getTutor().getEndereco().getComplemento();
        var bairro = agendaDto.getTutor().getEndereco().getBairro();

        if((logradouro == null || logradouro.isEmpty() || logradouro.isBlank())
                || (numero == null || numero.isEmpty() || numero.isBlank())) {
            throw new CustomException(ExceptionMessage.ENDERECO_REQUERIDO.getMessage());
        }

        bloco = Objects.requireNonNullElse(bloco, "N/I");
        apartamento = Objects.requireNonNullElse(apartamento, "N/I");
        complemento = Objects.requireNonNullElse(complemento, "N/I");
        bairro = Objects.requireNonNullElse(bairro, "N/I");

        var enderecoDto = EnderecoDto.builder()
                .logradouro(logradouro)
                .bairro(bairro)
                .complemento(complemento)
                .numero(numero)
                .bloco(bloco)
                .apartamento(apartamento)
                .build();

        return enderecoDto;
    }
}


