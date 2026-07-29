-- Migration para adicionar a coluna de descricao na tabela de food

ALTER TABLE food_items
ADD COLUMN descricao VARCHAR(255);