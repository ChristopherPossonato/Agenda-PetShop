CREATE TABLE agendamentos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dataHora DATETIME NOT NULL,
    transporte BOOLEAN,
    pacote VARCHAR(255) NOT NULL,
    dataVencimento DATE,
    statusAgendamento VARCHAR(255),
    status BOOLEAN,
    tutor_id BIGINT NOT NULL,
    animal_id BIGINT NOT NULL,
    funcionario_id BIGINT NOT NULL,
    FOREIGN KEY (tutor_id) REFERENCES tutores(id),
    FOREIGN KEY (animal_id) REFERENCES animais(id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id)
);
