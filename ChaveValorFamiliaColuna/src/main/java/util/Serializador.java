package util;

import java.io.*;

public class Serializador {

    public static byte[] serializar(Object obj) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            return bos.toByteArray();
        }
    }

    public static <T> T desserializar(byte[] dados, Class<T> classe) throws IOException, ClassNotFoundException {
        if (dados == null) {
            return null;
        }
        try (ByteArrayInputStream bis = new ByteArrayInputStream(dados);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return classe.cast(ois.readObject());
        }
    }
}