package br.univille.projetofinal.entity;
@Entity
    public class Produto{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private String nome;
        private float precoAtual;
        private int quantidae;
        private float desconto;
        private String nomeCupom;
        private Date dataFim;
        private Date dataInclusao;
    }