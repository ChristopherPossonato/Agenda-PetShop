package br.com.topicosnewm.petshop.dataprovider.repository;

import br.com.topicosnewm.petshop.dataprovider.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
