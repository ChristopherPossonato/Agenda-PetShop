package br.com.topicosnewm.petshop.dataprovider.model;

public enum Pacote {
    DIA_UNICO("Dia unico"),
    QUINZENAL("Quinzenal"),
    SEMANAL("Semanal"),
    MENSAL("Mensal");

    private final String descricao;

    Pacote(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
