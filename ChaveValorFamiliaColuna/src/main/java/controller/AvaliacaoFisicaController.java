package controller;

import java.io.IOException;
import java.util.List;

import dao.AvaliacaoFisicaDAO;
import dto.AvaliacaoFisicaDTO;
import dto.ExercicioDTO;
import mapper.MapperAvaliacaoFisica;
import model.AvaliacaoFisica;

public class AvaliacaoFisicaController {

    private AvaliacaoFisicaDAO dao;

    public AvaliacaoFisicaController() {
        this.dao = new AvaliacaoFisicaDAO();
    }

    public void adicionarAvaliacao(AvaliacaoFisicaDTO dto) throws IOException {
        dao.adicionarAvaliacao(dto);
    }


    public AvaliacaoFisicaDTO obterAvaliacao(AvaliacaoFisicaDTO dto) throws IOException, ClassNotFoundException {
    	return dao.obterAvaliacao(dto);
    }
    
    public void removerAvaliacao(AvaliacaoFisicaDTO dto) {
    	dao.removerAvaliacao(dto);
    }
}