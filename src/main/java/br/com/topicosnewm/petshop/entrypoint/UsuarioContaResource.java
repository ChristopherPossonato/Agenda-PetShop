package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.UsuarioContaDto;
import br.com.topicosnewm.petshop.entrypoint.model.usuarioconta.UsuarioContaRequest;
import br.com.topicosnewm.petshop.usecase.usuarioconta.UsuarioContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/criacao")
@Api(tags = "Criação Usuário", description = "Controller de criação de usuário")
public class UsuarioContaResource {
    @Autowired
    private UsuarioContaService usuarioContaService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    @ApiOperation(value = "Cria novo usuário.")
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid UsuarioContaRequest usuarioContaRequest, UriComponentsBuilder uriComponentsBuilder) {
        var usuarioDto = mapper.map(usuarioContaRequest, UsuarioContaDto.class);

        var usuarioDtoSalvo = usuarioContaService.criarConta(usuarioDto);

        var uri = uriComponentsBuilder.path("/criacao/{id}").buildAndExpand(usuarioDtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioDtoSalvo);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza usuário.")
    @Transactional
    public ResponseEntity<Long> alterar(@RequestBody UsuarioContaDto usuarioContaDto, @PathVariable("id") Long id) {

        usuarioContaDto.getId();

        Long idUsuarioAtualizado = usuarioContaService.alterar(usuarioContaDto);

        return ResponseEntity.ok(idUsuarioAtualizado);
    }

}
