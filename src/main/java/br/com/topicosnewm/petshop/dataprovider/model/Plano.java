package br.com.topicosnewm.petshop.dataprovider.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "planos")
@Data
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte tagPlano;
    private String nome;
    private Double vlPlanoMensal;
    private Boolean ativo;
    private Byte duracaoEmMeses;
    private Byte limitePerfilUsuario;
}
