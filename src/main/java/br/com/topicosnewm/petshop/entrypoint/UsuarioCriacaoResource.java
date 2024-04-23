package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.UsuarioCriacaoDto;
import br.com.topicosnewm.petshop.entrypoint.model.usuariocriacao.UsuarioCriacaoResponse;
import br.com.topicosnewm.petshop.entrypoint.model.usuariocriacao.UsuarioCriacaoRequest;
import br.com.topicosnewm.petshop.service.usuariocriacao.UsuarioCriacaoService;
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
public class UsuarioCriacaoResource {
    @Autowired
    private UsuarioCriacaoService usuarioCriacaoService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca usuário por Id.")
    public ResponseEntity<UsuarioCriacaoResponse> buscarPorId(@PathVariable Long id) {
        var obj = usuarioCriacaoService.buscarPorId(id).orElse(null);

        if (obj != null) {
            var ret = this.mapper.map(obj, UsuarioCriacaoResponse.class);
            System.out.println(ret);
            return ResponseEntity.ok(ret);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiOperation(value = "Cria novo usuário.")
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid UsuarioCriacaoRequest  usuarioCriacaoRequest, UriComponentsBuilder uriComponentsBuilder) {
        var usuarioDto = mapper.map(usuarioCriacaoRequest, UsuarioCriacaoDto.class);

        var usuarioDtoSalvo = usuarioCriacaoService.salvar(usuarioDto);

        var uri = uriComponentsBuilder.path("/criacao/{id}").buildAndExpand(usuarioDtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioDtoSalvo);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza usuário.")
    @Transactional
    public ResponseEntity<Long> alterar(@RequestBody UsuarioCriacaoDto usuarioCriacaoDto, @PathVariable("id") Long id) {

        usuarioCriacaoDto.getId();

        Long idUsuarioAtualizado = usuarioCriacaoService.alterar(usuarioCriacaoDto);

        return ResponseEntity.ok(idUsuarioAtualizado);
    }

}
