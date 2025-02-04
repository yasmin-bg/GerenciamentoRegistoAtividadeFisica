package dao;

import java.io.IOException;

import dto.AvaliacaoFisicaDTO;
import model.AvaliacaoFisica;

public interface IAvaliacaoFisicaDAO {
	
	public void adicionarAvaliacao(AvaliacaoFisicaDTO dto) throws IOException;
	public AvaliacaoFisicaDTO obterAvaliacao(AvaliacaoFisicaDTO dto) throws IOException, ClassNotFoundException;
}