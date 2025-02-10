package controller;

import java.io.IOException;
import java.util.List;

import dao.ExercicioDAO;
import dto.ExercicioDTO;
import model.Exercicio;

public class ExercicioController {

    private ExercicioDAO dao;

    public ExercicioController() {
        this.dao = new ExercicioDAO();
    }

    public void adicionarExercicio(ExercicioDTO dto) throws IOException {
    	dao.adicionarExercicio(dto);
    }

    public ExercicioDTO obterExercicio(ExercicioDTO dto) throws IOException, ClassNotFoundException {
    	return dao.obterExercicio(dto);
    }
    
    public void removerExercicio(ExercicioDTO dto) {
    	dao.removerExercicio(dto);
    }
}