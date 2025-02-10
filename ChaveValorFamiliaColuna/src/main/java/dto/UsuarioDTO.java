package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private long id;
    private String nome;  
    private String email; 
    private String senha; 

    public UsuarioDTO(long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public UsuarioDTO() {
    }
    
    public UsuarioDTO(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) { 
        this.senha = senha;
    }
}