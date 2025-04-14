

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class ContadorFrecuencia {

    public static Map<Character, Integer> contadorFrecuencia(String nombreArchivo) throws IOException{
        Map<Character, Integer> frecuencias = new HashMap<>();

        FileReader fr = new FileReader(nombreArchivo);
        int caracter;
        while ((caracter = fr.read())!= -1) {
            char c = (char) caracter;
            frecuencias.put(c, frecuencias.getOrDefault(c,0 )+1);
            
        }
        fr.close();
        return frecuencias;

    }


    public static PriorityQueue<Nodo> crearCola(Map<Character, Integer> frecuencias){
        PriorityQueue<Nodo> cola = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entrada : frecuencias.entrySet()){
            cola.add(new Nodo(entrada.getKey(), entrada.getValue()));
            
        }
        return cola;
    
}
}