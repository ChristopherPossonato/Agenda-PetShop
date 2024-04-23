CREATE TABLE usuario_conta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    dt_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN,
    tag_plano TINYINT,
    plano_id BIGINT,
    dt_expiracao DATETIME,
    CONSTRAINT fk_plano
        FOREIGN KEY (plano_id)
        REFERENCES plano(id)
        ON DELETE SET NULL
);