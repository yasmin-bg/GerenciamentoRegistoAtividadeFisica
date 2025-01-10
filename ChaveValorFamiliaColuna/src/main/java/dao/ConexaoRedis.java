package dao;

import redis.clients.jedis.Jedis;

public class ConexaoRedis {

    private static Jedis jedis;

    public static void abrirConexao() {
        if (jedis == null) {
            jedis = new Jedis("127.0.0.1", 6379);
            jedis.auth("senha");
            System.out.println("Conectado ao Redis");
        }
    }

    public static void fecharConexao() {
        if (jedis != null) {
            jedis.close();
            System.out.println("Conexão com o Redis fechada");
        }
    }

    public static Jedis getConexao() {
        return jedis;
    }
}