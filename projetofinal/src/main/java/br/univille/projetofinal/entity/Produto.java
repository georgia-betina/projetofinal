package br.univille.projetofinal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
    public class Produto{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
<<<<<<< HEAD
        @Column(length = 150, nullable = false)
=======
        private  long id;
>>>>>>> parent of 8eeabb5 (alteracoes)
=======
        private  long id;
>>>>>>> parent of 8eeabb5 (alteracoes)
        private String nome;
        private float precoAtual;
        private int quantidade;
        private float desconto;
        private String nomeCupom;
        private Date dataFim;
        private Date dataInclusao;
        @ManyToOne
        private Fornecedor fornecedor;

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
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
        public Date getDataFim() {
            return dataFim;
        }
        public void setDataFim(Date dataFim) {
            this.dataFim = dataFim;
        }
        public Date getDataInclusao() {
            return dataInclusao;
        }
        public void setDataInclusao(Date dataInclusao) {
            this.dataInclusao = dataInclusao;
        }
        public Fornecedor getFornecedor() {
            return fornecedor;
        }
        public void setFornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
        }
    }