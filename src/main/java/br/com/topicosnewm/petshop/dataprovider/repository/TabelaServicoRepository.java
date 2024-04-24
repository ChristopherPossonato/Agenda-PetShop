package br.com.topicosnewm.petshop.dataprovider.repository;

import br.com.topicosnewm.petshop.dataprovider.model.Pacote;
import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import br.com.topicosnewm.petshop.dataprovider.model.TabelaServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaServicoRepository extends JpaRepository<TabelaServico, Long> {

    boolean existsByTipoServicoAndPorteAndPacoteAndValorServico(String tipoServico, Porte porte, Pacote pacote, Double valorServico);

//    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TabelaServico t " +
//            "WHERE t.tipoServico = :tipoServico " +
//            "AND t.porte = :porte " +
//            "AND t.pacote = :pacote " +
//            "AND t.valor = :valor")
//    boolean existsByTipoServicoAndPorteAndPacoteAndValor(
//            @Param("tipoServico") String tipoServico,
//            @Param("porte") Porte porte,
//            @Param("pacote") Pacote pacote,
//            @Param("valor") Double valor);
    @Query("SELECT ts FROM TabelaServico ts WHERE ts.pacote = :pacote AND ts.porte = :porte AND ts.tipoServico = :tipoServico")
    TabelaServico findByTabelaServico(@Param("pacote") Pacote pacote, @Param("porte") Porte porte, @Param("tipoServico") String tipoServico);


}
