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
        String chave = "exercicio:" + dto.getId();
        String valor = mapperExercicio.toJson(dto);
        jedis.set(chave, valor);
    }

    public void atualizarExercicio(ExercicioDTO dto) {
        String chave = "exercicio:" + dto.getId();
        String valor = mapperExercicio.toJson(dto);
        jedis.set(chave, valor);
    }

    public Exercicio obterExercicio(ExercicioDTO dto) {
        String chave = "exercicio:" + dto.getId();
        String avaliacaoJson = jedis.get(chave);
        if (avaliacaoJson != null) {
            ExercicioDTO avaliacaoDTO = mapperExercicio.fromJson(avaliacaoJson);
            return mapperExercicio.toEntity(avaliacaoDTO);
        }
        return null;
    }

    public void excluirExercicio(ExercicioDTO dto) {
        String chave = "exercicio:" + dto.getId();
        jedis.del(chave);
    }
}