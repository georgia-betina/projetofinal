![HTML icon](https://img.shields.io/badge/HTML-FF4500?style=for-the-badge&logo=html5&logoColor=white) ![CSS icon](https://img.shields.io/badge/CSS-1471b6?&style=for-the-badge&logo=css3&logoColor=white) ![JS icon](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Java icon](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![Spring icon](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![Thymeleaf icon](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white) ![MariaDB icon](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)

# Projeto Final

Projeto final do curso "Novos Talentos em TI", fornecido pela Univille em parceria com a FAPESC, onde o objetivo era criar uma aplicação web de uma loja de periféricos *gamer* (CupomMania).

### Desafios

Criar um `MER (Modelo Entidade Relacional)` que suprisse todas as necessidades do sistema, desenvolver um sistema de `autenticação` baseado em *cookies*  utilizando funções do Spring Boot e fazer o *front-end* utilizando o `Thymeleaf`.

### Funcionalidades

#### Cliente

- Consegue criar um cadastro no CupomMania e a partir dele resgatar os cupons em voga nos sites parceiros;
- Sistema guarda a data de cadastro para validar posteriormente o cupom de boas-vindas, com validade de cinco meses, 5% *off* (não cumulativo) e está vinculado ao CPF;
- Consegue visualizar itens adicionados recentemente ao site.

#### Funcionário

- Possui um *seed* para adicionar outro(s) funcionário(s) e/ou fornecedor(es);
- Pode deletar produtos cadastrados por fornecedores do banco de dados;
- Cadastrar ou deletar fornecedor(es) do banco de dados;
- Alterar dados de outro(s) funcionário(s) e/ou fornecedor(es).

#### Fornecedor

- Recebe um login e senha de um funcionário para modificar posteriormente;
- Pode acrescentar produtos no site e automaticamente serem vinculados à sua empresa através do login no sistema;
- Pode deletar produtos antigos.

### Não implementado

Criar uma API que retornasse da loja parceira o CPF do consumidor para validar um dos critérios do cupom de boas-vindas.

## Preview
![Website preview](https://i.imgur.com/9tH3bGV.png)
