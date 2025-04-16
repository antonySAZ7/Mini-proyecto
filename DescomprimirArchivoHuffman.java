
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DescomprimirArchivoHuffman{
private static Map<String, Character> leerTablaCodigos(DataInputStream data) throws IOException {
    int cantidad = data.readInt();
    Map<String, Character> codigostabla = new HashMap<>();

    for(int i = 0; i < cantidad; i++){
        char c = data.readChar();
        String codigo = data.readUTF();
        codigostabla.put(codigo, c);

    }
    return codigostabla;
}







    
public static void descomprimir(String archivoComprimido, String archivoSalida) throws  IOException {
    FileInputStream entrada = new FileInputStream(archivoComprimido);
    DataInputStream data = new DataInputStream(entrada);


    Map<String, Character> codigosTabla = leerTablaCodigos(data);
    StringBuilder bits = new StringBuilder();
    while(data.available() > 0){
        int b = data.readUnsignedByte();
        String binario = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
        bits.append(binario);
    }
    data.close();
    entrada.close();


    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));
    StringBuilder codigoActual = new StringBuilder();
    for(int i = 0; i <bits.length(); i++){
        codigoActual.append(bits.charAt(i));
        if(codigosTabla.containsKey(codigoActual.toString())){
            escritor.write(codigosTabla.get(codigoActual.toString()));
            codigoActual.setLength(0);
        }
    }
    escritor.close();
} 


}
