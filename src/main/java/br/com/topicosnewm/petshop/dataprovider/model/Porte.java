package br.com.topicosnewm.petshop.dataprovider.model;

public enum Porte {
    MINI("MINI"),
    PEQUENO("PEQUENO"),
    MEDIO("MEDIO"),
    GRANDE("GRANDE"),
    GIGANTE("GIGANTE");

    private final String descricao;

    Porte(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

