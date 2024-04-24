package br.com.topicosnewm.petshop.dataprovider.model;

public enum Pacote {
    DIA_UNICO("DIA_UNICO"),
    QUINZENAL("QUINZENAL"),
    SEMANAL("SEMANAL"),
    MENSAL("MENSAL");

    private final String descricao;

    Pacote(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
