

CREATE TABLE tutores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nomeTutor VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255),
    numero VARCHAR(100),
    bairro VARCHAR(50),
    complemento VARCHAR(100),
    bloco VARCHAR(50),
    apartamento VARCHAR(100)
);
