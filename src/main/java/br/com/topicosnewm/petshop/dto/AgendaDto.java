package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AgendaDto {
    private Long id;
    private LocalDateTime dataHora;
    private Boolean transporte;
    private Pacote pacote;
    private LocalDateTime dataVencimento;
    private StatusAgendamento statusAgendamento;
    private Boolean status;
    private Tutor tutor;
    private Animal animal;
    private Funcionario funcionario;
}