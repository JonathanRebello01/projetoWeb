-- SQLBook: Code

-- Apagar o banco de dados
drop database bancoAluno;
-- Criar o banco de dados
create database bancoAluno;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON bancoAluno.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE bancoAluno;
-- Criar a tabela: usuario
CREATE TABLE aluno(
    matricula int,
    nome varchar(50) NOT NULL,
    idade int NOT NULL,
    email varchar(50) NOT NULL,
    PRIMARY KEY (matricula)
);



SELECT * FROM aluno