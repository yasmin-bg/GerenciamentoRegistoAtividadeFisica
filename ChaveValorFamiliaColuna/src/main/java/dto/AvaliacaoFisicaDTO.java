package dto;

public class AvaliacaoFisicaDTO {
	
    private Long id;
    private Long idUsuario;
    private double peso;
    private double altura;
    private double imc;

    public AvaliacaoFisicaDTO(Long id, Long idUsuario, double peso, double altura, double imc) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
	}
  
    public AvaliacaoFisicaDTO(Long id) {
		this.id = id;
	}

	public AvaliacaoFisicaDTO() {
    	
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
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