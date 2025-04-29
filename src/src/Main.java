package src;

import java.io.File;
import java.util.*;


public class Main {
    private static Scanner scaneer = new Scanner(System.in);

    public static void comprimir(){
        try{
            String archivoOriginal = "greeneggs.txt";
            String archivoComprimido = "comprimido.huff";

            Map<Character, Integer> frecuencias = ContadorFrecuencia.contadorFrecuencia(archivoOriginal);
            PriorityQueue<Nodo> cola = ContadorFrecuencia.crearCola(frecuencias);
            Nodo raiz =  ArbolHuffman.crearArbol(cola);
            Map<Character, String> codigos = CodificarHuffman.crearCodigo(raiz);
            System.out.println("\nCodigos Huffman generados: ");
            for(Map.Entry<Character, String> entrada : codigos.entrySet()){
                System.out.println("-" +entrada.getKey() + ": " + entrada.getValue());
            }
            ComprimirArchivoHuffman.comprimir(archivoOriginal, archivoComprimido, codigos);

            System.out.println("Archivoc comprimido con exitoo");
            System.out.println("Tamaño original: " + new File(archivoOriginal).length() + " bytes");
            System.out.println("Tamaño comprimido: " + new File(archivoComprimido).length() + " bytes");
        }catch(Exception e){
            System.out.println("Error al comprimir el archivo: ");
            e.printStackTrace();
        }
    }
    

    private  static void descomprimir(){
        try {
            String archivoComprimido = "comprimido.huff";
            String archivoSalido = "descomprimido.txt";

            DescomprimirArchivoHuffman.descomprimir(archivoComprimido, archivoSalido);
            System.out.println("Archivo descomprimido con exito");
            System.out.println("Tamaño reconstruir: " + new File(archivoSalido).length() + " bytes");

            
        } catch (Exception e) {
            System.out.println("Error al descomprimir el archivo: ");
            e.printStackTrace();
        }
    }


     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cuenta = 0;
        while(cuenta <1){
            System.out.println("Bienvenidos al compresor de archivos Huffman");
            System.out.println("1. Comprimir archivo (greeneggs.txt → comprimido.huff)");
            System.out.println("2. Descomprimir archivo (comprimido.huff → reconstruido.txt)");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    comprimir();
                    break;
                case 2:
                    descomprimir();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    cuenta++;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
     }

       
    


}
