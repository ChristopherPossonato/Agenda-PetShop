package br.com.topicosnewm.petshop.service.security;

import br.com.topicosnewm.petshop.dataprovider.repository.UsuarioCriacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UsuarioCriacaoRepository usuarioCriacaoRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return usuarioCriacaoRepository.findByLogin(userName);
    }
}
