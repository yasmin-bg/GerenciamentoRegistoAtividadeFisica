package dao;

import redis.clients.jedis.Jedis;


public class Conexao {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.auth("senha");

        System.out.println("Conectado ao Redis");
        System.out.println("Ping: " + jedis.ping());

        jedis.close();
    }
}