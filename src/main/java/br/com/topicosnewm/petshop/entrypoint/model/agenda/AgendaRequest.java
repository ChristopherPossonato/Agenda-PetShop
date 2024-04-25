package br.com.topicosnewm.petshop.entrypoint.model.agenda;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import br.com.topicosnewm.petshop.dto.FuncionarioDto;
import br.com.topicosnewm.petshop.dto.TabelaServicoDto;
import br.com.topicosnewm.petshop.dto.TutorDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({
        "dataHora",
        "transporte",
        "tipoServico",
        "pacote",
        "tutor"

})
public class AgendaRequest {
    private Long id;
    private LocalDateTime dataHora;
    private String tipoServico;
    private Boolean transporte;
    private Pacote pacote;
    private LocalDateTime dataVencimento;
    private StatusAgendamento statusAgendamento;
    private Boolean status;
    private TutorDto tutor;
    private FuncionarioDto funcionario;
    private TabelaServicoDto tabelaServico;
    private Double valor;
}

