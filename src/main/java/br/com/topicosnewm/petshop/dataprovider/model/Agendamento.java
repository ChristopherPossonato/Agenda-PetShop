package br.com.topicosnewm.petshop.dataprovider.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private LocalDateTime dataHora;

    private Boolean transporte;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Pacote pacote;
    private LocalDate dataVencimento;
    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario  funcionario;

    private TabelaPrecoServico tabelaPrecoServico;


    public void excluirAgendamento() {
        this.status = false;
    }
}
