package br.univille.projetofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
    public class Produto{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column(length = 150, nullable = false)
        private long id;
        private String nome;
        private String imagem;
        private float precoAtual;
        private int quantidade;
        private float desconto;
        private String nomeCupom;
        private String dataFim;
        private String dataInclusao;
        @ManyToOne
        private Fornecedor fornecedor;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getImagem() {
            return imagem;
        }
        public void setImagem(String imagem) {
            this.imagem = imagem;
        }
        public float getPrecoAtual() {
            return precoAtual;
        }
        public void setPrecoAtual(float precoAtual) {
            this.precoAtual = precoAtual;
        }
        public int getQuantidade() {
            return quantidade;
        }
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
        public float getDesconto() {
            return desconto;
        }
        public void setDesconto(float desconto) {
            this.desconto = desconto;
        }
        public String getNomeCupom() {
            return nomeCupom;
        }
        public void setNomeCupom(String nomeCupom) {
            this.nomeCupom = nomeCupom;
        }
        public String getDataFim() {
            return dataFim;
        }
        public void setDataFim(String dataFim) {
            this.dataFim = dataFim;
        }
        public String getDataInclusao() {
            return dataInclusao;
        }
        public void setDataInclusao(String dataInclusao) {
            this.dataInclusao = dataInclusao;
        }
        public Fornecedor getFornecedor() {
            return fornecedor;
        }
        public void setFornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
        }
    }