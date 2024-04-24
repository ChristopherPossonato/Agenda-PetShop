BEGIN;

ALTER TABLE tutores DROP FOREIGN KEY fk_tutores_animais;

ALTER TABLE tutores DROP COLUMN id_animal;


COMMIT;