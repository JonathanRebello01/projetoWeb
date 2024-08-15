# CRUD de Alunos

Este projeto é uma aplicação web para gerenciamento de alunos. Ele permite que você adicione, pesquise, liste e exclua registros de alunos usando uma interface simples com HTML, CSS e JavaScript. A aplicação faz uso da API RESTful para interagir com o banco de dados de alunos.

## Funcionalidades

- **Adicionar Aluno:** Permite o cadastro de um novo aluno com informações como nome, matrícula, e-mail e idade.
- **Pesquisar Aluno:** Permite buscar um aluno específico por matrícula.
- **Listar Todos os Alunos:** Exibe todos os alunos cadastrados em uma tabela.
- **Excluir Aluno:** Permite remover um aluno da lista de alunos.

## Tecnologias Utilizadas

- **Frontend:**
  - HTML
  - CSS (Bootstrap para estilos)
  - JavaScript (para interação com a API e manipulação do DOM)

- **Backend:**
  - Servidor RESTful (espera-se que a API esteja disponível no endpoint `http://localhost:8080/aluno`)
    
### Funcionalidades

- **Adicionar Aluno**
  - Preencha os campos de nome, matrícula, e-mail e idade.
  - Clique no botão "Salvar" para adicionar o aluno à base de dados.

- **Pesquisar Aluno**
  - Insira a matrícula do aluno no campo de pesquisa.
  - Clique no botão "Pesquisar" para encontrar o aluno.

- **Listar Todos os Alunos**
  - Clique no botão "Listar Todos" para exibir todos os alunos cadastrados.

- **Excluir Aluno**
  - Na lista de alunos, clique no botão "Excluir" ao lado do aluno que deseja remover. O aluno será removido da base de dados e da lista exibida.

## Estrutura do Projeto

- **index.html**: Página principal que contém o formulário e a tabela de alunos.
- **script.js**: Arquivo JavaScript que gerencia a interação com a API e a manipulação do DOM.
- **style.css** (opcional): Arquivo CSS para estilos personalizados (se necessário).

## API Endpoints

- **Adicionar Aluno**: `POST http://localhost:8080/aluno/inserir`
- **Pesquisar Aluno**: `GET http://localhost:8080/aluno/obter/{matricula}`
- **Listar Todos os Alunos**: `GET http://localhost:8080/aluno/listar`
- **Excluir Aluno**: `DELETE http://localhost:8080/aluno/deletar/{matricula}`
