package br.com.topicosnewm.petshop.entrypoint.model.agendamento;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({
        "dataHora",
        "trasnporte",
        "pacote",
        "status",
        "tutor",
        "animal",
        "funcionario",
})
public class AgendamentoRequest {
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