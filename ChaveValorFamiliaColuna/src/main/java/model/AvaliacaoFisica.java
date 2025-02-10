package model;

public class AvaliacaoFisica {
	
    private long id;
    private long idUsuario;
    private byte[] peso;
    private byte[] altura;
    private byte[] imc;
    
	public AvaliacaoFisica(long id, long idUsuario, byte[] peso, byte[] altura, byte[] imc) {
		super();
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

	public byte[] getPeso() {
		return peso;
	}

	public void setPeso(byte[] peso) {
		this.peso = peso;
	}

	public byte[] getAltura() {
		return altura;
	}

	public void setAltura(byte[] altura) {
		this.altura = altura;
	}

	public byte[] getImc() {
		return imc;
	}

	public void setImc(byte[] imc) {
		this.imc = imc;
	}
}