package dao;

import dto.AvaliacaoFisicaDTO;
import model.AvaliacaoFisica;

public interface IAvaliacaoFisicaDAO {
	
	public void adicionarAvaliacao(AvaliacaoFisicaDTO dto);
	public AvaliacaoFisica obterAvaliacao(AvaliacaoFisicaDTO dto);
	public void atualizarAvaliacao(AvaliacaoFisicaDTO dto);
	public void excluirAvaliacao(AvaliacaoFisicaDTO dto);
}