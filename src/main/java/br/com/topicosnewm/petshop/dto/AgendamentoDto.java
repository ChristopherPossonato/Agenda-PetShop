package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AgendamentoDto {
    private Long id;
    private LocalDateTime dataHora;
    private Boolean transporte;
    private Pacote pacote;
    private LocalDate dataVencimento;
    private StatusAgendamento statusAgendamento;
    private Boolean status;
    private Tutor tutor;
    private Animal animal;
    private Funcionario funcionario;
}