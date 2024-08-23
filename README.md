
# 📚 Sistema de Gerênciamento de Biblioteca

Este projeto é parte do desafio do Módulo 1 do curso de Java da Rocketseat. O objetivo é desenvolver um sistema de gerenciamento de biblioteca.

## 🛠️ Descrição do Sistema

O sistema permite realizar operações básicas de gerenciamento de uma biblioteca, incluindo o cadastro de clientes, livros, autores, além de gerenciar empréstimos. Abaixo estão as funcionalidades principais:

### 🔍 Funcionalidades

- **👤 Cadastrar Cliente**: Permite cadastrar um novo cliente com os seguintes dados:
  - 📝 Nome
  - 🆔 Nome de usuário (único)
  - 🎂 Data de nascimento
  - ✉️ Email

- **📖 Gerenciamento de Livros**:
  - ➕ Cadastrar um novo livro
  - 📅 A data de cadastro do livro é registrada automaticamente, assim como cada atualização de seu uso.
  - 📚 Verificar os livros disponíveis para empréstimo
  - 🔍 Pesquisar um livro específico utilizando o título
  - 🎨 Pesquisar livros de um determinado gênero literário (gêneros literários previamente determinados em um enum)

- **🖊️ Gerenciamento de Autores**:
  - ➕ Cadastrar um novo autor, com os seguintes dados:
    - 📝 Nome
    - 🎂 Data de nascimento

- **🔄 Empréstimos**:
  - 👥 Verificar o histórico de empréstimos de um usuário específico
  - 📅 Verificar o histórico de empréstimos de um livro específico

- **⚠️ Regras de Empréstimo**:
  - 🚫 Cada livro pode ser emprestado apenas uma vez durante a execução do programa.
  - ❌ Não é permitido realizar empréstimos para clientes não cadastrados.
  - 📕 **Ao realizar um empréstimo, o livro escolhido deve ser marcado como indisponível e, durante esta execução do programa, NÃO poderá ser emprestado novamente.**

- **🚪 Sair**: Encerrar o programa.

## 🗂️ Entidades Principais

- **📘 Livro**: Cada livro possui um UUID único, título e autor e registra automaticamente a data de cadastro e atualizações de uso.
- **👤 Cliente**: Cada cliente possui um UUID único, além de um nome, nome de usuário (único) e data de nascimento.
- **📄 Empréstimo**: Representa o empréstimo de um livro para um cliente. Ficam guardadas as informações do livro emprestado, cliente que realizou o empréstimo e data do emrpéstimo.
- **🏛️ Biblioteca**: Reúne as listas de livros, clientes, autores e empréstimos.
- **🖋️ Autor**: Cada autor possui um UUID único, nome e data de nascimento.

## ▶️ Como Usar

O programa é executado a partir da classe `Main`, onde o usuário pode interagir com o sistema através de um menu de opções.

## 🔗 Link do Desafio

Para mais detalhes sobre o desafio, acesse o [link do desafio](https://efficient-sloth-d85.notion.site/Desafio-Sistema-de-Livraria-5af3421be6384b4e87dcff80897e9efb).
