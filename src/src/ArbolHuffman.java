package src;

import java.util.PriorityQueue;

/**
 * Clase para construir el árbol de Huffman.
 */
public class ArbolHuffman {

    /**
     * Crea un árbol de Huffman a partir de una cola de prioridad.
  
     */
    public static Nodo crearArbol(PriorityQueue<Nodo> cola) {
        while (cola.size() > 1) {
            Nodo nodo1 = cola.poll();
            Nodo nodo2 = cola.poll();
            Nodo nodoPadre = new Nodo(nodo1.frecuencia + nodo2.frecuencia, nodo1, nodo2);
            cola.add(nodoPadre);
        }
        return cola.poll();
    }
}
