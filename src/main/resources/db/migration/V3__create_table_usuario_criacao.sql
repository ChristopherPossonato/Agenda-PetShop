CREATE TABLE usuario_criacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    login VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    dt_criacao TIMESTAMP,
    ativo TINYINT(1),
    tag_plano TINYINT,
    plano_id BIGINT,
    FOREIGN KEY (plano_id) REFERENCES planos(id)
);
