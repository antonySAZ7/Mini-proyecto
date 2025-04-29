package src;

/**
 * Representa un nodo en el árbol de Huffman.
 */
public class Nodo implements Comparable<Nodo> {
    public char caracter;
    public int frecuencia;
    public Nodo izquierdo;
    public Nodo derecho;

    
    public Nodo(int frecuencia, Nodo izquierdo, Nodo derecho) {
        this.caracter = '\0';
        this.frecuencia = frecuencia;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Nodo(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public int compareTo(Nodo otroNodo) {
        return this.frecuencia - otroNodo.frecuencia;
    }

    
    public boolean eshoja() {
        return (izquierdo == null && derecho == null);
    }
}