package src;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase para generar códigos Huffman.
 */
public class CodificarHuffman {

    /**
     * Genera los códigos Huffman a partir de un árbol.
   
     */
    public static Map<Character, String> crearCodigo(Nodo raiz) {
        Map<Character, String> codigos = new HashMap<>();
        recorerArbol(raiz, "", codigos);
        return codigos;
    }

    private static void recorerArbol(Nodo nodo, String camino, Map<Character, String> codigos) {
        if (nodo == null) {
            return;
        }
        if (nodo.eshoja()) {
            codigos.put(nodo.caracter, camino);
        } else {
            recorerArbol(nodo.izquierdo, camino + "0", codigos);
            recorerArbol(nodo.derecho, camino + "1", codigos);
        }
    }
}
