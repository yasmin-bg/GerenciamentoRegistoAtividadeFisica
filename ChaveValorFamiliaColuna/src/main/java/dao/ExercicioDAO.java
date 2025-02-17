package dao;

import dto.ExercicioDTO;
import redis.clients.jedis.Jedis;
import java.io.IOException;

public class ExercicioDAO extends ConexaoRedis implements IExercicioDAO {

    public void adicionarExercicio(ExercicioDTO dto) throws IOException {
        String chave = "exercicio:" + dto.getId();
        String valor = dto.getTipoExercicio();
        
        try (Jedis jedis = getJedis()) {
            jedis.set(chave, valor); 
        }
    }

    public ExercicioDTO obterExercicio(ExercicioDTO dto) throws IOException {
        String chave = "exercicio:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            String valor = jedis.get(chave); 
            return valor != null ? new ExercicioDTO(dto.getId(), valor) : null; 
        }
    }

    public void removerExercicio(ExercicioDTO dto) {
        String chave = "exercicio:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            jedis.del(chave);
        }
    }
}