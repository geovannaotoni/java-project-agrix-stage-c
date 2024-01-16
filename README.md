# Agrix: Sistema de Gestão de Fazendas da AgroTech 🌱🏞️
A AgroTech é uma empresa busca desenvolver tecnologias para aprimorar a eficiência no cultivo de plantações. O primeiro produto da empresa, o Agrix, é um sistema de gestão e monitoramento das fazendas participantes. Este projeto é a fase final do desenvolvimento do projeto. A fase A está [neste repositório](https://github.com/geovannaotoni/java-project-agrix-stage-a/tree/main) e a fase B está [neste repositório](https://github.com/geovannaotoni/java-project-agrix-stage-b/).

## 🏛️ Estrutura do Banco de Dados
Este modelo inclui as seguintes tabelas:
- **farm**: Representa uma fazenda.
- **crop**: Representa uma plantação e está em relacionamento N:1 ("muitos para um") com a tabela **farm**.
- **fertilizer**: Representa um fertilizante, e está em um relacionamento N:N ("muitos para muitos") com a tabela **crop**. Esse relacionamento é realizado através da tabela **crop_fertilizer**.

## ✅ Endpoints ajustados ou incluídos na Fase C:
* `POST /persons`: Recebe no corpo da requisição o username, password e role para salvar a nova pessoa no banco.
* `POST /auth/login`: Rota para login que retorna um JWT. Recebe username e password no corpo da requisição e retorna um campo token.
* `GET /farms`: Acesso limitado para que apenas uma pessoa autenticada com role USER, MANAGER ou ADMIN possa acessar.
* `GET /crops`: Acesso limitado para que apenas uma pessoa autenticada com role MANAGER ou ADMIN possa acessar.
* `GET /fertilizers`: Acesso limitado para que apenas uma pessoa autenticada com role ADMIN possa acessar.

## ⚙️ Habilidades trabalhadas
Este projeto visa o desenvolvimento de uma aplicação Spring Boot com funcionalidades iniciais para gestão de fazendas e plantios. Ele aborda as seguintes habilidades:
- Implementação de rotas da API Rest usando o ecossistema Spring.
- Utilização de injeção de dependência para conectar camadas de controle, serviço e persistência.
- Utilização do Spring Data JPA para entidades e repositórios de persistência em banco de dados.
- Implementação de gerenciamento de erros no Spring Web.
- Criação de um Dockerfile para configurar a aplicação para execução no Docker.
- Estruturação do Banco de Dados.
- Utilização campos de data nas rotas da API e no banco de dados.
- Criação de testes unitários para garantir a qualidade e funcionamento correto da implementação, com cobertura de código adequada.
- Aplicar o conhecimento sobre Spring Security para adicionar autenticação ao projeto.

## 💻 Como Executar o Projeto
1. Clone o repositório.
2. Suba o ambiente com Docker Compose (ver abaixo).
3. Execute a aplicação Spring Boot com  o comando `mvn spring-boot:run`.
4. Utilize ferramentas como Postman, Insomnia ou seu navegador para acessar os endpoints da API.
- O arquivo `Agrix.postman_collection.json` contém exemplos de requisições para todos os endpoints da aplicação.

## 🛠️ Configuração do Ambiente
Certifique-se de ter o Docker instalado na sua máquina antes de prosseguir.

1. Subir o ambiente:
```bash
docker-compose up -d
```
2. Encerrar o ambiente:
```bash
docker-compose down
```
