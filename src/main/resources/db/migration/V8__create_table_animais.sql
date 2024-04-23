CREATE TABLE animais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    raca VARCHAR(255) NOT NULL,
    porte VARCHAR(50) NOT NULL,
    tutor_id BIGINT NOT NULL,
    CONSTRAINT fk_tutor_animal FOREIGN KEY (tutor_id) REFERENCES tutores (id)
);
