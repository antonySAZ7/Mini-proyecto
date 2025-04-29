package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import src.ArbolHuffman;
import src.CodificarHuffman;
import src.ComprimirArchivoHuffman;
import src.ContadorFrecuencia;
import src.Nodo;
import src.DescomprimirArchivoHuffman;

import java.io.*;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Clase de pruebas para las funcionalidades de Huffman.
 */
public class HuffmanTest {

    /**
     * Prueba la generación de códigos Huffman.
     */
    @Test
    public void pruebaGenerarCodigos() throws IOException {
        // Crear un archivo pequeño de prueba
        String textoPrueba = "aabac";
        String nombreArchivo = "prueba.txt";

        BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
        escritor.write(textoPrueba);
        escritor.close();

        // Procesar el archivo
        Map<Character, Integer> frecuencias = ContadorFrecuencia.contadorFrecuencia(nombreArchivo);
        PriorityQueue<Nodo> cola = ContadorFrecuencia.crearCola(frecuencias);
        Nodo raiz = ArbolHuffman.crearArbol(cola);
        Map<Character, String> codigos = CodificarHuffman.crearCodigo(raiz);

        // Asegurar que hay códigos generados
        assertNotNull(codigos.get('a'));
        assertNotNull(codigos.get('b'));
        assertNotNull(codigos.get('c'));

        // Eliminar archivo de prueba
        new File(nombreArchivo).delete();
    }

    /**
     * Prueba la compresión y descompresión de un archivo.
     */
    @Test
    public void pruebaComprimirYDescomprimir() throws IOException {
        // Crear un archivo pequeño de prueba
        String textoPrueba = "green eggs and ham";
        String archivoOriginal = "originalTest.txt";
        String archivoComprimido = "comprimidoTest.huff";
        String archivoDescomprimido = "reconstruidoTest.txt";

        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoOriginal));
        escritor.write(textoPrueba);
        escritor.close();

        // COMPRESIÓN
        Map<Character, Integer> frecuencias = ContadorFrecuencia.contadorFrecuencia(archivoOriginal);
        PriorityQueue<Nodo> cola = ContadorFrecuencia.crearCola(frecuencias);
        Nodo raiz = ArbolHuffman.crearArbol(cola);
        Map<Character, String> codigos = CodificarHuffman.crearCodigo(raiz);
        ComprimirArchivoHuffman.comprimir(archivoOriginal, archivoComprimido, codigos);

        // DESCOMPRESIÓN
        DescomprimirArchivoHuffman.descomprimir(archivoComprimido, archivoDescomprimido);

        // Comparar los archivos
        String original = leerArchivo(archivoOriginal);
        String descomprimido = leerArchivo(archivoDescomprimido);

        assertEquals(original.trim(), descomprimido.trim(), "El archivo descomprimido debe ser igual al original.");

        // Eliminar archivos de prueba
        new File(archivoOriginal).delete();
        new File(archivoComprimido).delete();
        new File(archivoDescomprimido).delete();
    }

    
    private String leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            contenido.append(linea).append("\n");
        }
        lector.close();
        return contenido.toString().trim();
    }
}
