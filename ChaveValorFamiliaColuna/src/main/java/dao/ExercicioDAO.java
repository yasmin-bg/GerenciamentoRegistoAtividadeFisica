package dao;

import dto.ExercicioDTO;
import mapper.MapperExercicio;
import model.Exercicio;
import redis.clients.jedis.Jedis;

public class ExercicioDAO implements IExercicioDAO {

    private Jedis jedis;
    private MapperExercicio mapperExercicio;

    public ExercicioDAO() {
        this.jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("senha");
        this.mapperExercicio = new MapperExercicio();
    }

    public void adicionarExercicio(ExercicioDTO dto) {
        try {
            String chave = String.valueOf(dto.getId());
            String valor = mapperExercicio.toJson(dto);
            jedis.set(chave, valor); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Exercicio obterExercicio(ExercicioDTO dto) {
        String chave = String.valueOf(dto.getId()); 
        String exercicioJson = jedis.get(chave);
        if (exercicioJson != null) {
            ExercicioDTO dtoExercicio = mapperExercicio.fromJson(exercicioJson);
            return mapperExercicio.toEntity(dtoExercicio);
        }
        return null;
    }

    public void excluirExercicio(ExercicioDTO dto) {
        String chave = String.valueOf(dto.getId());
        jedis.del(chave);
    }
    
    public void atualizarExercicio(ExercicioDTO dto) {
        String chave = String.valueOf(dto.getId()); 
        String valor = mapperExercicio.toJson(dto);
        jedis.set(chave, valor);
    }
}