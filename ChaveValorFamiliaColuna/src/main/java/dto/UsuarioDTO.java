package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	private long id;
    private String nome;
    
	public UsuarioDTO() {
	
	}

	public UsuarioDTO(long id, String nome) {
		this.id = id;
		this.nome = nome;
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
}