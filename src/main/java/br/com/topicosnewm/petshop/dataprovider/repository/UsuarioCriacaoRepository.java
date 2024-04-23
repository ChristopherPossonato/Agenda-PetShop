package br.com.topicosnewm.petshop.dataprovider.repository;

import br.com.topicosnewm.petshop.dataprovider.model.Plano;
import br.com.topicosnewm.petshop.dataprovider.model.UsuarioCriacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCriacaoRepository extends JpaRepository<UsuarioCriacao, Long> {

    UserDetails findByLogin(String login);


}
