package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Pacote;
import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TabelaServicoDto {
    private Long id;
    private String tipoServico;
    private Porte porte;
    private Pacote pacote;
    private Double valor;
}
