package br.univille.projetofinal.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
    public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(length = 14, nullable = false)
        private String CPF;
        @Column(length = 128, nullable = false)
        private String nome;
        @Column(length = 50, nullable = false)
        private String login;
        @Column(length = 50, nullable = false)
        private String senha;
        private boolean jaComprou;
        @Temporal(value = TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(nullable = false)
        private Date dataCadastro;
        @Column(nullable = false)
        private ArrayList<Produto> listaProdutos = new ArrayList<>();
        
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getCPF() {
            return CPF;
        }
        public void setCPF(String cPF) {
            CPF = cPF;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getLogin() {
            return login;
        }
        public void setLogin(String login) {
            this.login = login;
        }
        public String getSenha() {
            return senha;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }
        public boolean isJaComprou() {
            return jaComprou;
        }
        public void setJaComprou(boolean jaComprou) {
            this.jaComprou = jaComprou;
        }
        public Date getDataCadastro() {
            return dataCadastro;
        }
        public void setDataCadastro(Date dataCadastro) {
            this.dataCadastro = dataCadastro;
        }
        public ArrayList<Produto> getListaProdutos() {
            return listaProdutos;
        }
        public void setListaProdutos(ArrayList<Produto> listaProdutos) {
            this.listaProdutos = listaProdutos;
        }
    }

//organizar a edentação dos códigos sempre. A famosa buniteza.
//dúvida com git e dúvida com entitys...
//livro código limpo