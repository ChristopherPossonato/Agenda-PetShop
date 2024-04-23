package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import br.com.topicosnewm.petshop.entrypoint.model.funcionario.FuncionarioRequest;
import br.com.topicosnewm.petshop.service.funcionario.FuncionarioService;
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
@RequestMapping("/funcionarios")
@Api(tags = "Funcionario", description = "Controller de funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cadastra novo funcionário.")
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid FuncionarioRequest funcionarioRequest, UriComponentsBuilder uriComponentsBuilder) {
        var funcionarioDto = modelMapper.map(funcionarioRequest,FuncionarioDto.class);

        var funcionarioSalvo = funcionarioService.salvar(funcionarioDto);


        var uri = uriComponentsBuilder.path("/funcionarios/{id}").buildAndExpand(funcionarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionarioSalvo);
    }
}
