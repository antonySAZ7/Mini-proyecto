

import java.io.*;
import java.util.Map;
public class ComprimirArchivoHuffman {

    private static void guardarTablaCodigos(DataOutputStream data, Map<Character, String> codigos) throws IOException {
        data.writeInt(codigos.size());
        for (Map.Entry<Character, String> entrada : codigos.entrySet()) {
            data.writeChar(entrada.getKey());
            data.writeUTF(entrada.getValue());
        }
    }



    public static void comprimir(String archivoEntrada, String archivoSalida, Map<Character, String> codigos) throws IOException {
        FileReader lector = new FileReader(archivoEntrada);
        StringBuilder bits = new StringBuilder();

        int c;
        while ((c = lector.read())!= -1) {
            char cha = (char) c;
            bits.append(codigos.get(cha));
             
        }
        lector.close();

        FileOutputStream salida = new FileOutputStream(archivoSalida);
        DataOutputStream data =  new DataOutputStream(salida);

        guardarTablaCodigos(data, codigos);
        while (bits.length() % 8 != 0) {
            bits.append("0");

            
        }

        for(int i = 0; i <bits.length(); i+=8){
            String byteString =  bits.substring(i, i+8);
            int b = Integer.parseInt(byteString, 2);
            data.writeByte(b);


        }
        data.close();
        salida.close();
}
}