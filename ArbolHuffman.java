

import java.util.PriorityQueue;

public class ArbolHuffman {
    public static Nodo crearArbol(PriorityQueue<Nodo> cola){
        while(cola.size() > 1){
            Nodo nodo1= cola.poll();
            Nodo nodo2 = cola.poll();
            Nodo nodoPadre = new Nodo(nodo1.frecuencia + nodo2.frecuencia, nodo1, nodo2);
            cola.add(nodoPadre);
        }
        return cola.poll();

    }




    
}
