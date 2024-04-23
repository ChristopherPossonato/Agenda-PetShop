package br.com.topicosnewm.petshop.dataprovider.model;

import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Table(name = "funcionarios")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String profissao;
    private Double comissao;


}
