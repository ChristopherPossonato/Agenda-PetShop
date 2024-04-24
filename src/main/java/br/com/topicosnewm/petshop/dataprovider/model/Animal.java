package br.com.topicosnewm.petshop.dataprovider.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animais")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Porte porte;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor tutor;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNomeAnimal() {
//        return nomeAnimal;
//    }
//
//    public void setNomeAnimal(String nomeAnimal) {
//        this.nomeAnimal = nomeAnimal;
//    }
//
//    public String getRaca() {
//        return raca;
//    }
//
//    public void setRaca(String raca) {
//        this.raca = raca;
//    }
//
//    public Porte getPorte() {
//        return porte;
//    }
//
//    public void setPorte(Porte porte) {
//        this.porte = porte;
//    }
//
//    public Tutor getTutor() {
//        return tutor;
//    }
//
//    public void setTutor(Tutor tutor) {
//        this.tutor = tutor;
//    }
}
