package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import br.com.topicosnewm.petshop.dataprovider.model.Tutor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDto {
    private Long id;
    private String nomeAnimal;
    private String raca;
    private Porte porte;
    private Tutor tutor;

}
