CREATE TABLE planos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tag_plano TINYINT,
    nome VARCHAR(255) NOT NULL,
    vl_plano_mensal DOUBLE,
    ativo TINYINT(1),
    duracao_em_meses TINYINT,
    limite_perfil_usuario TINYINT
);