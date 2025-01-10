package dao;

import dto.ExercicioDTO;
import model.Exercicio;

public interface IExercicioDAO {
	
	public void adicionarExercicio(ExercicioDTO dto);
	public Exercicio obterExercicio(ExercicioDTO dto);
	public void excluirExercicio(ExercicioDTO dto);
	public void atualizarExercicio(ExercicioDTO dto);
}