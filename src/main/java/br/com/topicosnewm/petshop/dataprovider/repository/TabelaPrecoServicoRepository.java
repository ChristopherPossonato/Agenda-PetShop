package br.com.topicosnewm.petshop.dataprovider.repository;

import br.com.topicosnewm.petshop.dataprovider.model.Pacote;
import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import br.com.topicosnewm.petshop.dataprovider.model.TabelaPrecoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaPrecoServicoRepository extends JpaRepository<TabelaPrecoServico, Long> {

    boolean existsByTipoServicoAndPorteAndPacoteAndValor(String tipoServico, Porte porte, Pacote pacote, Double valor);

//    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TabelaPrecoServico t " +
//            "WHERE t.tipoServico = :tipoServico " +
//            "AND t.porte = :porte " +
//            "AND t.pacote = :pacote " +
//            "AND t.valor = :valor")
//    boolean existsByTipoServicoAndPorteAndPacoteAndValor(
//            @Param("tipoServico") String tipoServico,
//            @Param("porte") Porte porte,
//            @Param("pacote") Pacote pacote,
//            @Param("valor") Double valor);
}
