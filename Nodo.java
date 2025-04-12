


public class Nodo implements Comparable<Nodo>{
    public char caracter;
    public int frecuencia;
    public Nodo izquierdo;
    public Nodo derecho;
    public char getCaracter() {
        return caracter;
    }
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }
    public int getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    public Nodo getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }
    public Nodo getDerecho() {
        return derecho;
    }
    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
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

    @Override
    public boolean eshoja(){
        return (izquierdo ==null && derecho == null);
        
    }


    
}