package br.com.topicosnewm.petshop.dataprovider.repository;

import br.com.topicosnewm.petshop.dataprovider.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
