package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private long id;
    private byte[] nome;  
    private byte[] email; 
    private byte[] senha; 

    public UsuarioDTO(long id, byte[] nome, byte[] email, byte[] senha) {
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

    public byte[] getNome() {
        return nome;
    }

    public void setNome(byte[] nome) {
        this.nome = nome;
    }

    public byte[] getEmail() {
        return email;
    }

    public void setEmail(byte[] email) {
        this.email = email;
    }

    public byte[] getSenha() {
        return senha;
    }

    public void setSenha(byte[] senha) { 
        this.senha = senha;
    }
}