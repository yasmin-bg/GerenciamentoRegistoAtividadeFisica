package controller;

import dao.AvaliacaoFisicaDAO;
import dto.AvaliacaoFisicaDTO;
import mapper.MapperAvaliacaoFisica;
import model.AvaliacaoFisica;

public class AvaliacaoFisicaController {

    private AvaliacaoFisicaDAO dao;

    public AvaliacaoFisicaController() {
        this.dao = new AvaliacaoFisicaDAO();
    }

    public void adicionarAvaliacao(AvaliacaoFisicaDTO dto) {
        dao.adicionarAvaliacao(dto);
    }

    public AvaliacaoFisica obterAvaliacao(AvaliacaoFisicaDTO dto) {
    	return dao.obterAvaliacao(dto);
    }

    public void atualizarAvaliacao(AvaliacaoFisicaDTO dto) {
        dao.atualizarAvaliacao(dto);
    }

    public void excluirAvaliacao(AvaliacaoFisicaDTO dto) {
    	dao.excluirAvaliacao(dto);
    }
}