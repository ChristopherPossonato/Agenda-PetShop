package br.com.topicosnewm.petshop.entrypoint.model.tutor;

import br.com.topicosnewm.petshop.dataprovider.model.Animal;
import br.com.topicosnewm.petshop.dataprovider.model.Endereco;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder({
        "nomeTutor",
        "telefone",
        "endereco"
})
public class TutorRequest {
    private Long id;
    private String nomeTutor;
    private String telefone;
    private Endereco endereco;
    private List<Animal> animais;
}