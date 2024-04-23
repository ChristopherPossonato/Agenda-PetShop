package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.AgendaDto;
import br.com.topicosnewm.petshop.entrypoint.model.agenda.AgendaRequest;
import br.com.topicosnewm.petshop.service.agenda.AgendaService;
import br.com.topicosnewm.petshop.service.animal.AnimalService;
import br.com.topicosnewm.petshop.service.funcionario.FuncionarioService;
import br.com.topicosnewm.petshop.service.tutor.TutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/agendamentos")
@Api(tags = "Agendamentos", description = "Controller de agendamentos")
public class AgendaResource {

    @Autowired
    private AgendaService agendaService;
    @Autowired
    private ModelMapper mapper;
    private TutorService tutorService;
    private AnimalService animalService;
    private FuncionarioService funcionarioService;

    @PostMapping
    @ApiOperation(value = "Agenda.")
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid AgendaRequest agendaRequest, UriComponentsBuilder uriComponentsBuilder) {
        var agendaDto = mapper.map(agendaRequest, AgendaDto.class);

        var agendaSalva = agendaService.agendar(agendaDto);


        var uri = uriComponentsBuilder.path("/agendamentos/{id}").buildAndExpand(agendaSalva.getId()).toUri();
        return ResponseEntity.created(uri).body(agendaSalva);
    }
}
