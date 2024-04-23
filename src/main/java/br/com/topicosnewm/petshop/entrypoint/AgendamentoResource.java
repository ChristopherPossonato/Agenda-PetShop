package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.service.agendamento.AgendamentoService;
import br.com.topicosnewm.petshop.service.animal.AnimalService;
import br.com.topicosnewm.petshop.service.funcionario.FuncionarioService;
import br.com.topicosnewm.petshop.service.tutor.TutorService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
@Api(tags = "Agendamentos", description = "Controller de agendamentos")
public class AgendamentoResource {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private ModelMapper mapper;
    private TutorService tutorService;
    private AnimalService animalService;
    private FuncionarioService funcionarioService;


}
