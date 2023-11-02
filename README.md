
# Simulador Simplificado do PicPay

Este projeto é um simulador simplificado do PicPay, que permite transações financeiras entre usuários comuns e lojistas. Ele foi desenvolvido utilizando o banco de dados H2 para armazenamento de dados e inclui tratamento de exceções.

## Entidades

A aplicação consiste em duas entidades principais:

1. **Usuário**: Representa um usuário da plataforma, que pode ser do tipo "comum" ou "lojista". Os usuários comuns podem enviar dinheiro, enquanto os lojistas podem apenas receber transações.

2. **Transação**: Cada transação é composta por um remetente (sender) e um destinatário (receiver). As transações são usadas para transferir dinheiro entre os usuários.

## Funcionalidades

A aplicação oferece as seguintes funcionalidades:

- **Cadastro de Usuários**: Os usuários podem ser cadastrados na aplicação, especificando seu tipo (comum ou lojista).

- **Envio de Dinheiro**: Usuários comuns podem enviar dinheiro para outros usuários, incluindo lojistas. No entanto, lojistas não podem enviar dinheiro.

- **Consulta de Saldo**: Os usuários podem verificar seus saldos.

## Banco de Dados

O projeto utiliza o banco de dados H2 para armazenamento de dados. Isso permite que os dados sejam persistidos de forma simples e eficiente durante a execução da aplicação.

## Tratamento de Exceções

A aplicação inclui tratamento de exceções para garantir que erros sejam gerenciados de forma adequada e que o usuário receba mensagens informativas em caso de problemas.

## Endpoints (Controllers)

A aplicação disponibiliza os seguintes endpoints (controllers):

- **Usuários (Users Controller)**
  - `POST /users`: Cria um novo usuário.
  - `GET /users`: Retorna a lista de todos os usuários cadastrados.

- **Transações (Transactions Controller)**
  - `POST /transactions`: Realiza uma nova transação.
  - `GET /transactions`: Retorna a lista de todas as transações realizadas.

## Requisitos

Certifique-se de que você tenha as seguintes dependências instaladas:

- Java JDK (versão 17 ou superior)
- Maven 
- Banco de Dados H2 (configurado na aplicação)

## Execução

Para executar a aplicação, siga estas etapas:

1. Clone o repositório para a sua máquina local.
2. Abra o projeto no seu ambiente de desenvolvimento (por exemplo, IntelliJ IDEA ou Eclipse).
3. Certifique-se de que o banco de dados H2 esteja configurado corretamente.
4. Compile e execute o projeto.

Após a execução, a aplicação estará disponível em http://localhost:8080. Você pode acessar os endpoints mencionados acima para interagir com a aplicação.
