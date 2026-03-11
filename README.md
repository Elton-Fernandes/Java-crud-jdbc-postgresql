Sistema CRUD de Clientes e Produtos — Java + PostgreSQL

Este projeto é um CRUD de clientes e produtos desenvolvido em Java, utilizando JDBC para conexão com banco de dados PostgreSQL.
A aplicação funciona via console e permite cadastrar, listar, alterar e deletar, aplicando boas práticas de organização de código e separação de responsabilidades.

Funcionalidades

Cadastrar cliente (nome e email)
Cadastraar Produto (nome e preço)
Listar
Alterar dados
Deletar
Prevenção contra SQL Injection com PreparedStatement
Menu interativo em loop

Tecnologias Utilizadas

Java 8
JDBC
PostgreSQL
IntelliJ IDEA
Git / GitHub

Conceitos Aplicados

Programação Orientada a Objetos (POO)
Padrão DAO (Data Access Object)
Separação de responsabilidades
Uso de PreparedStatement
Tratamento de exceções com try-with-resources
Modularização do código
Boas práticas de organização

🗄️ Estrutura da Tabela no Banco
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE produto (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE,
	preco NUMERIC(10,2) NOT NULL
);

▶️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/nome-do-repositorio.git


Configure o banco de dados PostgreSQL

Ajuste as credenciais na classe Conexao.java

Execute a classe Main

Use o menu no console para interagir com o sistema

 Autor

Elton Fernandes
Estudante de Desenvolvimento Backend
Focado em Java, Banco de Dados e boas práticas de programação.
