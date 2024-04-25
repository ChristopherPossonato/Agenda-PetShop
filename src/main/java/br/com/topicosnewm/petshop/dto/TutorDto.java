package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Animal;
import br.com.topicosnewm.petshop.dataprovider.model.Endereco;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorDto {
    private Long id;
    private String nomeTutor;
    private String telefone;
    private EnderecoDto endereco;
    private List<AnimalDto> animais;
}