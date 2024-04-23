package br.com.topicosnewm.petshop.service.security;

import br.com.topicosnewm.petshop.dataprovider.repository.UsuarioCriacaoRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioCriacaoRepository usuarioCriacaoRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if(tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var usuarioCriacao = usuarioCriacaoRepository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuarioCriacao, null, usuarioCriacao.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        var authozizationHeader = request.getHeader("Authorization");
        if(authozizationHeader != null) {
            return authozizationHeader.replace("Bearer ", "");
        }
      return null;
    }
}
