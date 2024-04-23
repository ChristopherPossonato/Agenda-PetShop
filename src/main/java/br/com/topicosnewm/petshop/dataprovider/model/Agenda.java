package br.com.topicosnewm.petshop.dataprovider.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Data
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    @Column(name = "transporte")
    private Boolean transporte;

    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_agendamento")
    private StatusAgendamento statusAgendamento;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario  funcionario;

    @ManyToOne
    @JoinColumn(name = "id_tabela_servico", nullable = false)
    private TabelaServico tabelaServico;


    public void excluirAgendamento() {
        this.status = false;
    }
}
