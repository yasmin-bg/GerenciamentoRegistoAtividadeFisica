package controller;

import dao.ExercicioDAO;
import dto.ExercicioDTO;
import mapper.MapperExercicio;
import model.Exercicio;

public class ExercicioController {

    private ExercicioDAO dao;
    private MapperExercicio mapperExercicio;

    public ExercicioController() {
        this.dao = new ExercicioDAO();
        this.mapperExercicio = new MapperExercicio();
    }

    public void adicionarExercicio(ExercicioDTO dto) {
        Exercicio exercicio = mapperExercicio.toEntity(dto);
        dao.adicionarExercicio(dto);
    }

    public Exercicio obterExercicio(ExercicioDTO dto) {
    	return dao.obterExercicio(dto);
    }

    public void excluirExercicio(ExercicioDTO dto) {
    	dao.excluirExercicio(dto);
    }

    public void atualizarExercicio(ExercicioDTO dto) {
        Exercicio exercicio = mapperExercicio.toEntity(dto);
        dao.atualizarExercicio(dto);
    }
}