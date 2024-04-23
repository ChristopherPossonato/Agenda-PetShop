CREATE TABLE tabela_preco_servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_servico VARCHAR(255) NOT NULL,
    porte VARCHAR(50),
    pacote VARCHAR(50),
    valor DOUBLE
);
