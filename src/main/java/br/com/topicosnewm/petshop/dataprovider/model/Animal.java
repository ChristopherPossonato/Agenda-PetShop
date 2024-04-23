package br.com.topicosnewm.petshop.dataprovider.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "animais")
@Data
@Builder
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_animal")
    private String nomeAnimal;

    @Column(name = "raca")
    private String raca;

    @Enumerated(EnumType.STRING)
    @Column(name = "porte")
    @NotBlank
    private Porte porte;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor tutor;

}
