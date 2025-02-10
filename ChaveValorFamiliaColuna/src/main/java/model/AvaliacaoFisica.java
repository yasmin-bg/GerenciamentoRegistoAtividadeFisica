package model;

public class AvaliacaoFisica {
	
    private long id;
    private long idUsuario;
    private String peso;
    private String altura;
    private String imc;
    
	public AvaliacaoFisica(long id, long idUsuario, String peso, String altura, String imc) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
	}

	public AvaliacaoFisica() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}
}