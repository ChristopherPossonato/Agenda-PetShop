
BEGIN;

-- Adicionando chave estrangeira na tabela agenda para a tabela tutores
ALTER TABLE agenda
ADD CONSTRAINT fk_agenda_tutor FOREIGN KEY (id_tutor) REFERENCES tutores(id_tutor);

-- Adicionando chave estrangeira na tabela agenda para a tabela funcionarios
ALTER TABLE agenda
ADD CONSTRAINT fk_agenda_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id);

-- Adicionando chave estrangeira na tabela agenda para a tabela tabela_servicos
ALTER TABLE agenda
ADD CONSTRAINT fk_agenda_tabela_servico FOREIGN KEY (id_tabela_servico) REFERENCES tabela_servicos(id);

-- Adicionando chave estrangeira na tabela animais para a tabela tutores
ALTER TABLE animais
ADD CONSTRAINT fk_animais_tutor FOREIGN KEY (id_tutor) REFERENCES tutores(id_tutor);

-- Adicionando chave estrangeira na tabela tutores para a tabela animais
ALTER TABLE tutores
ADD CONSTRAINT fk_tutores_animais FOREIGN KEY (id_animal) REFERENCES animais(id);

-- Adicionando chave estrangeira na tabela usuario_contas para a tabela planos
ALTER TABLE usuario_contas
ADD CONSTRAINT fk_usuario_contas_plano FOREIGN KEY (plano_id) REFERENCES planos(id);


COMMIT;