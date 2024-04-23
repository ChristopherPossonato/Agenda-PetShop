package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Animal;
import br.com.topicosnewm.petshop.dataprovider.model.Endereco;
import lombok.Data;

import java.util.List;

@Data
public class TutorDto {
    private Long id;
    private String nomeTutor;
    private String telefone;
    private Endereco endereco;
    private List<Animal> animais;

}