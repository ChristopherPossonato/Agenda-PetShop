package br.com.topicosnewm.petshop.service.security;

import br.com.topicosnewm.petshop.dataprovider.model.UsuarioCriacao;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${app.jwt.secret}")
    private String secretKey ;

    public String gerarToken(UsuarioCriacao usuarioCriacao) {
        try {
            var algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("API Topicos NewM")
                    .withSubject(usuarioCriacao.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    public String getSubject(String tokenjWT) {
        try {
            var algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("API Topicos NewM")
                    .build()
                    .verify(tokenjWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw  new RuntimeException("Token JWT inválido ou expirado");
        }
    }
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.of("-03:00"));
    }
}
