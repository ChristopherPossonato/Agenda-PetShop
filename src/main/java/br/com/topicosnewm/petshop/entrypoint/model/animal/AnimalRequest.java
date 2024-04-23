package br.com.topicosnewm.petshop.entrypoint.model.animal;

import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import br.com.topicosnewm.petshop.dataprovider.model.Tutor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
@Data
@JsonPropertyOrder({
        "nome",
        "raca",
        "porte",
        "tutor"
})
public class AnimalRequest {
        private Long id;
        private String nome;
        private String raca;
        private Porte porte;
        private Tutor tutor;

}
