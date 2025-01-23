package model;

public class AvaliacaoFisica {
	
    private Long id;
    private Long idUsuario;
    private Double peso;
    private Double altura;
    private Double imc;
    private String data;
    
    public AvaliacaoFisica(Long id, Long idUsuario, Double peso, Double altura, Double imc, String data) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
		this.data = data;
	}

	public AvaliacaoFisica() {
		
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

    public void setIdUsuario(Long usuarioId) {
        this.idUsuario = usuarioId;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}