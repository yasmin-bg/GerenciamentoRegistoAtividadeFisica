package controller;

import java.util.List;

import dao.ExercicioDAO;
import dto.ExercicioDTO;
import model.Exercicio;

public class ExercicioController {

    private ExercicioDAO dao;

    public ExercicioController() {
        this.dao = new ExercicioDAO();
    }

    public void adicionarExercicio(ExercicioDTO dto) {
    	dao.adicionarExercicio(dto);
    }

    public Exercicio obterExercicio(ExercicioDTO dto) {
    	return dao.obterExercicio(dto);
    }

    public void excluirExercicio(ExercicioDTO dto) {
    	dao.excluirExercicio(dto);
    }

    public void atualizarExercicio(ExercicioDTO dto) {
       dao.atualizarExercicio(dto);
    }
    
    public List<ExercicioDTO> listarTodosExerciciosComUsuarioRelacionado() {
    	return dao.listarTodosExerciciosComUsuarioRelacionado();
    }
}