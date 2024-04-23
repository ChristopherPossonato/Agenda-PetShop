package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.TabelaServicoDto;
import br.com.topicosnewm.petshop.entrypoint.model.tabelaservico.TabelaServicoRequest;
import br.com.topicosnewm.petshop.service.tabelaservico.TabelaServicoService;
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
@RequestMapping("/servico")
@Api(tags = "Tabela Serviço", description = "Controller de serviços")
public class TabelaServicoResource {

    @Autowired
    private TabelaServicoService tabelaServicoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cadastra novo servico.")
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid TabelaServicoRequest tabelaServicoRequest, UriComponentsBuilder uriComponentsBuilder) {
        var precoServicoDto = modelMapper.map(tabelaServicoRequest, TabelaServicoDto.class);

        var precoServicoSalvo = tabelaServicoService.salvar(precoServicoDto);


        var uri = uriComponentsBuilder.path("/servico/{id}").buildAndExpand(precoServicoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(precoServicoSalvo);
    }
}
