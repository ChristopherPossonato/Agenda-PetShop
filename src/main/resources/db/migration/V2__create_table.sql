BEGIN;

CREATE TABLE agenda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME NOT NULL,
    transporte TINYINT(1),
    pacote VARCHAR(255) NOT NULL,
    data_vencimento DATETIME,
    status_agendamento VARCHAR(255),
    status BOOLEAN,
    id_tutor BIGINT NOT NULL,
    id_funcionario BIGINT NOT NULL,
    id_tabela_servico BIGINT NOT NULL
);

CREATE TABLE animais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_animal VARCHAR(255) NOT NULL,
    raca VARCHAR(255) ,
    porte VARCHAR(255) NOT NULL,
    id_tutor BIGINT NOT NULL
);


CREATE TABLE funcionarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    profissao VARCHAR(255) NOT NULL

);


CREATE TABLE tabela_servicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_servico VARCHAR(255) NOT NULL,
    porte VARCHAR(255) NOT NULL,
    pacote VARCHAR(255) NOT NULL,
    valor_servico DOUBLE NOT NULL
);


CREATE TABLE tutores (
    id_tutor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_tutor VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    complemento VARCHAR(255) ,
    bairro VARCHAR(255) NOT NULL,
    bloco VARCHAR(255) ,
    apartamento VARCHAR(255) ,
    id_animal BIGINT NOT NULL
);

CREATE TABLE usuario_contas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255),
    cpf_cnpj VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    dt_criacao DATETIME,
    ativo BOOLEAN,
    tag_plano TINYINT,
    plano_id BIGINT,
    dt_expiracao DATETIME
);

COMMIT;


