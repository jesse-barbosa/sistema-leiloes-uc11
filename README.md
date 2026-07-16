# Sistema de Leilões

Projeto Java para informatizar as rotinas de uma casa de leilões. A aplicação possui interfaces gráficas para cadastrar produtos, consultar os itens disponíveis e acompanhar o status de venda.

## Tecnologias utilizadas

- Java
- Java Swing
- MySQL
- JDBC (MySQL Connector/J)
- Apache Ant
- NetBeans IDE
- Git e GitHub

## Estrutura do projeto

- `src/`: código-fonte e formulários da aplicação.
- `database/uc11.sql`: script para criação e carga da tabela `produtos`.
- `lib/`: drivers JDBC utilizados para a conexão com o MySQL.
- `nbproject/`: configurações do projeto NetBeans.

## Banco de dados

1. Inicie o servidor MySQL.
2. Crie um banco de dados chamado `uc11`.
3. Importe o arquivo `database/uc11.sql` nesse banco.
4. Verifique os dados de acesso configurados em `src/conectaDAO.java`.

## Execução

Abra o projeto no NetBeans, confirme a disponibilidade do MySQL e execute a classe `cadastroVIEW` para acessar a tela inicial do Sistema de Leilões.

## Autor

Jessé Barbosa

