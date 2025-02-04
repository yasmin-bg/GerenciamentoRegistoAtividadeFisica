package model;

public class AvaliacaoFisica {
	
    private long id;
    private long idUsuario;
    private double peso;
    private double altura;
    private double imc;

    public AvaliacaoFisica(long id, long idUsuario, double peso, double altura, double imc) {
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}