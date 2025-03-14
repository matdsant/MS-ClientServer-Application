# MsClient - Microserviço de Gerenciamento de Clientes

Microserviço responsável pelo gerenciamento de clientes, incluindo operações de cadastro e consulta de clientes através do CPF. Este serviço foi desenvolvido com Spring Boot e faz parte de uma arquitetura baseada em microserviços.

## 🚀 Funcionalidades
- **Cadastrar Cliente**: Realiza o cadastro de um cliente fornecendo CPF, nome e idade.
- **Buscar Cliente por CPF**: Permite a consulta de um cliente utilizando seu CPF como chave de busca.

## 🧑‍💻 Arquitetura
Este projeto é construído utilizando uma arquitetura de microserviços com Spring Boot e Spring Cloud, com foco em escalabilidade e descoberta de serviços através do Eureka Server.

A aplicação interage com o banco de dados para persistência de dados dos clientes, sendo inicialmente configurada para rodar com o banco **H2** em memória.

## 🛠 Tecnologias
- **Java 17**: A linguagem principal utilizada no desenvolvimento do projeto.
- **Spring Boot**: Framework que facilita a criação de microserviços e aplicações web.
- **Spring Data JPA**: Para interação com o banco de dados relacional de forma simples e eficiente.
- **H2 Database**: Banco de dados em memória, utilizado para o desenvolvimento e testes.
- **Spring Cloud Eureka**: Para registrar e descobrir outros serviços dentro de uma arquitetura de microserviços.
- **Lombok**: Biblioteca para reduzir a verbosidade do código, gerando automaticamente getters, setters e construtores.
- **JUnit 5**: Framework de testes utilizado para garantir a qualidade do código.

## 📦 Como Rodar

### 1. Clonar o Repositório
Clone o repositório para sua máquina local.

### 2. Configurar o Banco de Dados
O projeto já está configurado para utilizar o **H2 Database** em memória, mas se desejar usar outro banco de dados, edite as configurações no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

Caso opte por um banco como **MySQL** ou **PostgreSQL**, adicione as configurações apropriadas e as dependências no `pom.xml`.

### 3. Construir e Rodar a Aplicação
Para rodar o projeto, utilize o Maven. Primeiro, construa o projeto:

```bash
./mvnw clean install
```

E depois execute a aplicação com o comando:

```bash
./mvnw spring-boot:run
```

Ou, se preferir, execute o `.jar` gerado:

```bash
java -jar target/MsClient-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível por padrão em `http://localhost:8080`.

## 🧪 Testando a API
Aqui estão alguns exemplos de como interagir com a API através de requisições HTTP.

### 1. Cadastrar um Novo Cliente
Use o método **POST** para cadastrar um cliente com as informações de CPF, nome e idade:

```http
POST http://localhost:8080/clients/
Content-Type: application/json

{
    "cpf": "12345678901",
    "nome": "João Silva",
    "idade": 30
}
```

**Resposta esperada:**

```json
{
    "id": 1,
    "cpf": "12345678901",
    "nome": "João Silva",
    "idade": 30
}
```

### 2. Buscar Cliente por CPF
Use o método **GET** para buscar um cliente utilizando seu CPF:

```http
GET http://localhost:8080/clients/12345678901
```

**Resposta esperada:**

```json
{
    "id": 1,
    "cpf": "12345678901",
    "nome": "João Silva",
    "idade": 30
}
```

### 3. Verificar o Status da API
Use o método **GET** para verificar o status da aplicação:

```http
GET http://localhost:8080/clients/
```

**Resposta esperada:**

```
ok
```

## 🧩 Testes Automatizados
Este projeto utiliza o **JUnit 5** para garantir a qualidade do código. Para rodar os testes, execute o comando:

```bash
./mvnw test
```

Isso irá executar todos os testes unitários configurados para a aplicação.

### Testes Implementados
- Testes para salvar e buscar um cliente no banco de dados.
- Testes para garantir que os dados do cliente sejam manipulados corretamente.

## ⚙️ Endpoints

| Método | Endpoint        | Descrição                          |
|---------|----------------|----------------------------------|
| **GET** | `/clients/`     | Verifica o status da aplicação. |
| **POST** | `/clients/`     | Cadastra um novo cliente.      |
| **GET** | `/clients/{cpf}` | Consulta um cliente pelo CPF. |

---

📌 **Observação**: Certifique-se de que o Eureka Server esteja rodando corretamente caso a aplicação faça parte de um ecossistema de microserviços.

💡 Para mais detalhes, consulte a documentação oficial do [Spring Boot](https://spring.io/projects/spring-boot).