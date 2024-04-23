package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import br.com.topicosnewm.petshop.dataprovider.model.Tutor;
import lombok.Data;

@Data
public class AnimalDto {
    private Long id;
    private String nome;
    private String raca;
    private Porte porte;
    private Tutor tutor;

}
