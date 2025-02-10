package dao;

import java.io.IOException;

import dto.ExercicioDTO;
import model.Exercicio;

public interface IExercicioDAO {
	
	public void adicionarExercicio(ExercicioDTO dto) throws IOException;
	public ExercicioDTO obterExercicio(ExercicioDTO dto) throws IOException, ClassNotFoundException;
}