package dao;

import dto.ExercicioDTO;
import redis.clients.jedis.Jedis;
import util.Serializador;
import java.io.IOException;

public class ExercicioDAO extends ConexaoRedis implements IExercicioDAO {

    public void adicionarExercicio(ExercicioDTO dto) throws IOException {
        String chave = "exercicio:" + dto.getId();
        byte[] dadosSerializados = Serializador.serializar(dto);
        
        try (Jedis jedis = getJedis()) {
            jedis.set(chave.getBytes(), dadosSerializados);
        }
    }

    public ExercicioDTO obterExercicio(ExercicioDTO dto) throws IOException, ClassNotFoundException {
        String chave = "exercicio:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            byte[] dados = jedis.get(chave.getBytes()); 
            return (dados != null) ? Serializador.desserializar(dados, ExercicioDTO.class) : null;
        }
    }
    
    public void removerExercicio(ExercicioDTO dto) {
        String chave = "exercicio:" + dto.getId();
        
        try (Jedis jedis = getJedis()) {
            jedis.del(chave.getBytes()); 
        }
    }
}