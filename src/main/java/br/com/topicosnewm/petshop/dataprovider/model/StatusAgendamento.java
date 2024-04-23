package br.com.topicosnewm.petshop.dataprovider.model;

public enum StatusAgendamento {
    PENDENTE("Pendente"),
    CHEGOU("Chegou"),
    EM_BANHO("Em banho"),
    PRONTO_TUTOR_AVISADO("Pet pronto e tutor avisado"),
    SAIU("Saiu"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
