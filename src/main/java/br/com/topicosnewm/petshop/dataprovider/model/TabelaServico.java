package br.com.topicosnewm.petshop.dataprovider.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tabela_servicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabelaServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "tipo_servico")
    private String tipoServico;
    @Enumerated(EnumType.STRING)
    @Column(name = "porte")
    private Porte porte;
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "pacote")
    private Pacote pacote;
    @Column(name = "valor_servico")
    private Double valorServico;
}
