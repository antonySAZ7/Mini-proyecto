package src;

import java.io.*;
import java.util.Map;

/**
 * Clase para comprimir archivos usando Huffman.
 */
public class ComprimirArchivoHuffman {

    /**
     * Comprime un archivo usando códigos Huffman.
     
     */
    public static void comprimir(String archivoEntrada, String archivoSalida, Map<Character, String> codigos) throws IOException {
        FileReader lector = new FileReader(archivoEntrada);
        StringBuilder bits = new StringBuilder();

        int c;
        int contadorCaracteres = 0;
        while ((c = lector.read()) != -1) {
            char cha = (char) c;
            bits.append(codigos.get(cha));
            contadorCaracteres++;
        }
        lector.close();

        FileOutputStream salida = new FileOutputStream(archivoSalida);
        DataOutputStream data = new DataOutputStream(salida);

        guardarTablaCodigos(data, codigos);

        data.writeInt(contadorCaracteres);

        while (bits.length() % 8 != 0) {
            bits.append("0");
        }

        for (int i = 0; i < bits.length(); i += 8) {
            String byteString = bits.substring(i, i + 8);
            int b = Integer.parseInt(byteString, 2);
            data.writeByte(b);
        }

        data.close();
        salida.close();
    }

    private static void guardarTablaCodigos(DataOutputStream data, Map<Character, String> codigos) throws IOException {
        data.writeInt(codigos.size());
        for (Map.Entry<Character, String> entrada : codigos.entrySet()) {
            data.writeChar(entrada.getKey());
            data.writeUTF(entrada.getValue());
        }
    }
}
