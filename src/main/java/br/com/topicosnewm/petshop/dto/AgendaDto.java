package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendaDto {
    private Long id;
    private LocalDateTime dataHora;
    private Boolean transporte;
    private String tipoServico;
    private Pacote pacote;
    private LocalDateTime dataVencimento;
    private StatusAgendamento statusAgendamento;
    private Boolean status;
    private TutorDto tutor;
    private FuncionarioDto funcionario;
    private TabelaServicoDto tabelaServico;
    private Double valor;
}