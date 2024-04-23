package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.PlanoDto;
import br.com.topicosnewm.petshop.entrypoint.model.plano.PlanoRequest;
import br.com.topicosnewm.petshop.service.plano.PlanoService;
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
@RequestMapping("/planos")
@Api(tags = "Cadastro Plano", description = "Controller de cadastro plano")
public class PlanoResource {


    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PlanoService planoService;

    @PostMapping
    @ApiOperation(value = "Cadastra novo plano.")
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid PlanoRequest planoRequest, UriComponentsBuilder uriComponentsBuilder) {
        var planoDto = mapper.map(planoRequest, PlanoDto.class);

        var usuarioDtoSalvo = planoService.salvar(planoDto);

        var uri = uriComponentsBuilder.path("/planos/{id}").buildAndExpand(usuarioDtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioDtoSalvo);
    }

}
