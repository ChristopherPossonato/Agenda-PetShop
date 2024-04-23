package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.dataprovider.model.UsuarioCriacao;
import br.com.topicosnewm.petshop.dto.DadosTokenDto;
import br.com.topicosnewm.petshop.dto.UsuarioLoginDto;
import br.com.topicosnewm.petshop.service.security.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Api(tags = "Login", description = "Controller de login")
public class AutenticacaoResource {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    @ApiOperation(value = "Login usuário.")
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto) {
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(usuarioLoginDto.getLogin(), usuarioLoginDto.getPassword());
        var authentication = authenticationManager.authenticate(authenticationTokentoken);

        var tokenJWT = tokenService.gerarToken((UsuarioCriacao) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenDto(tokenJWT));
    }
}
