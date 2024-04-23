package br.com.topicosnewm.petshop.dataprovider.repository;

import br.com.topicosnewm.petshop.dataprovider.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    @Query("SELECT p FROM Plano p WHERE p.tagPlano = :tagPlano")
    Plano getReferenceByTagPlano(@Param("tagPlano") Byte tagPlano);

}
