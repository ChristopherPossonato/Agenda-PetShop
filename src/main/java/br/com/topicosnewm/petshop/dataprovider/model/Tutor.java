package br.com.topicosnewm.petshop.dataprovider.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tutores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_tutor;

        @NotBlank
        @Column(name = "nome_tutor")
        private String nomeTutor;

        @NotBlank
        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "Formato de telefone inválido")
        @Column(name = "telefone")
        private String telefone;

        @Embedded
        private Endereco endereco;

        @OneToMany(mappedBy = "tutor", cascade = CascadeType.PERSIST)
        private List<Animal> animais;
}
