package br.com.topicosnewm.petshop.dataprovider.model;

public enum StatusAgendamento {
    PENDENTE("PENDENTE"),
    CHEGOU("CHEGOU"),
    EM_BANHO("EM_BANHO"),
    PRONTO_TUTOR_AVISADO("PRONTO_TUTOR_AVISADO"),
    SAIU("SAIU"),
    CANCELADO("CANCELADO");

    private final String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
