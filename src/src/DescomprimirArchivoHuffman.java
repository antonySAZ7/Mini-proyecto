package src;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para descomprimir archivos usando Huffman.
 */
public class DescomprimirArchivoHuffman {

    
    public static void descomprimir(String archivoEntrada, String archivoSalida) throws IOException {
        FileInputStream entrada = new FileInputStream(archivoEntrada);
        DataInputStream data = new DataInputStream(entrada);

        Map<String, Character> codigosTabla = leerTablaCodigos(data);

        int caracteresTotales = data.readInt();

        StringBuilder bits = new StringBuilder();

        try {
            while (true) {
                int b = data.readUnsignedByte();
                String byteString = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
                bits.append(byteString);
            }
        } catch (EOFException e) {
            // Fin del archivo
        }

        data.close();
        entrada.close();

        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

        StringBuilder temp = new StringBuilder();
        int caracteresReconstruidos = 0;

        for (int i = 0; i < bits.length(); i++) {
            temp.append(bits.charAt(i));
            if (codigosTabla.containsKey(temp.toString())) {
                escritor.write(codigosTabla.get(temp.toString()));
                temp.setLength(0);
                caracteresReconstruidos++;

                if (caracteresReconstruidos == caracteresTotales) {
                    break;
                }
            }
        }

        escritor.close();
    }

    private static Map<String, Character> leerTablaCodigos(DataInputStream data) throws IOException {
        int cantidad = data.readInt();
        Map<String, Character> codigosTabla = new HashMap<>();

        for (int i = 0; i < cantidad; i++) {
            char c = data.readChar();
            String codigo = data.readUTF();
            codigosTabla.put(codigo, c);
        }
        return codigosTabla;
    }
}
