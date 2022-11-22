package br.univille.projetofinal.entity;
@Entity
    public class Funcionario{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String login;
        private String senha;


    }