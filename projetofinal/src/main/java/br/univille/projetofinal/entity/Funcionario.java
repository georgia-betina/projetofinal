package br.univille.projetofinal.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
    public class Funcionario{
        @Id
        private String login;
        private String senha;
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
    }