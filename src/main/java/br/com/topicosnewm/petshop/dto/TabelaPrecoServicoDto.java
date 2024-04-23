package br.com.topicosnewm.petshop.dto;

import br.com.topicosnewm.petshop.dataprovider.model.Pacote;
import br.com.topicosnewm.petshop.dataprovider.model.Porte;
import lombok.Data;

@Data
public class TabelaPrecoServicoDto {
    private Long id;
    private String tipoServico;
    private Porte porte;
    private Pacote pacote;
    private Double valor;
}
