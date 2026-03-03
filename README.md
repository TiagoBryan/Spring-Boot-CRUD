# API Pessoas - CRUD

Projeto backend desenvolvido em Java com Spring Boot. O objetivo é fornecer uma API REST para operações de CRUD (Create, Read, Update, Delete) de entidades do tipo "Pessoa", utilizando arquitetura em camadas e o padrão DTO.

## Tecnologias

- Java 21 (ou superior)
- Spring Boot 3.x
- Maven
- Spring Data JPA
- H2 Database (banco de dados em memória)
- Lombok

## Como executar

Certifique-se de ter o Java e o Maven configurados no ambiente.

1. Clone o repositório e acesse a pasta raiz do projeto.
2. Para iniciar a aplicação via terminal, execute o comando:

mvn spring-boot:run

O servidor iniciará localmente na porta 8080. O banco de dados H2 é recriado a cada inicialização em memória.

## Endpoints

URL Base: http://localhost:8080/api/pessoas

### 1. Criar Pessoa (POST)
Cria um novo registro.

Endpoint: `POST /api/pessoas`

Payload:
{
  "nome": "Tiago Oliveira",
  "telefone": "11999999999",
  "endereco": "Rua das Flores, 123"
}

### 2. Listar Pessoas (GET)
Retorna todos os registros salvos.

Endpoint: `GET /api/pessoas`

### 3. Atualizar Pessoa (PUT)
Atualiza os dados de uma pessoa existente. Retorna apenas o ID e o Nome.

Endpoint: `PUT /api/pessoas/{id}`

Payload:
{
  "nome": "Tiago Oliveira Alterado",
  "telefone": "11888888888",
  "endereco": "Avenida Brasil, 456"
}

Resposta esperada:
{
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "nome": "João Silva Alterado"
}

### 4. Deletar Pessoa (DELETE)
Remove um registro pelo ID.

Endpoint: `DELETE /api/pessoas/{id}`

Resposta esperada (Status 200 OK):
Pessoa deletada com sucesso!
