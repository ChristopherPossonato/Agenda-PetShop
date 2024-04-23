package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dto.TabelaPrecoServicoDto;
import br.com.topicosnewm.petshop.entrypoint.model.tabelaprecoservico.TabelaPrecoServicoRequest;
import br.com.topicosnewm.petshop.service.tabelaprecoservico.TabelaPrecoServicoService;
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
@RequestMapping("/tabela/preco")
@Api(tags = "Tabela Serviço", description = "Controller de serviços")
public class TabelaPrecoServicoResource {

    @Autowired
    private TabelaPrecoServicoService tabelaPrecoServicoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Cadastra novo servico.")
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid TabelaPrecoServicoRequest tabelaPrecoServicoRequest, UriComponentsBuilder uriComponentsBuilder) {
        var precoServicoDto = modelMapper.map(tabelaPrecoServicoRequest, TabelaPrecoServicoDto.class);

        var precoServicoSalvo = tabelaPrecoServicoService.salvar(precoServicoDto);


        var uri = uriComponentsBuilder.path("/tabela/preco/{id}").buildAndExpand(precoServicoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(precoServicoSalvo);
    }
}
