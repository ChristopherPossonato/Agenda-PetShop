package br.com.topicosnewm.petshop.exception;

public enum ExceptionMessage {
    ACESSO_NEGADO("Acesso negado"),
    TUTOR_NAO_LOCALIZADA("Tutor não localizado"),
    CNPJ_JA_CADASTRADO("CNPJ já cadastrado"),
    CNPJ_INVALIDO("CNPJ inválido"),
    LOGIN_JA_UTILIZADO("Login já utilizado"),
    NOME_APP_JA_UTILIZADO("Nome de aplicação já utilizado"),
    PERFIL_NAO_LOCALIZADO("Perfil não localizado"),
    PERFIL_REQUERIDO("Informe o perfil"),
    REGISTRO_NAO_LOCALIZADO("Registro não localizado"),
    SENHA_ATUAL_NAO_CONFERE("Senha atual não confere"),
    UPDATE_EXCEPTION("Falha ao salvar o registro"),
    USUARIO_NAO_LOCALIZADO("Usuário não localizado"),
    USUARIO_REQUERIDO("Informe o usuário"),
    ENDERECO_REQUERIDO("Os campos logradouro e número precisam ser preenchidos"),
    SERVICO_NAO_ENCONTRADO("Servico não encontrado");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
