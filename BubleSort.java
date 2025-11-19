import java.io.BufferedReader;
import java.io.FileReader;

public class BubleSort {
    // Iniciamos con la construcción de un main

    public static void main(String[] args) {
    String archivoEntrada = "numerosBubleSort.txt";
    String archivoSalida = "numerosBubleSort_ordenados.txt";

        int[] numeros = leerArchivo(archivoEntrada);

        if (numeros != null) {
            System.out.println("numeros originales:");
            imprimirArray(numeros);

            bubbleSort(numeros);

            System.out.println("\n numeros ordenados (Bubble Sort):");
            imprimirArray(numeros);

            escribirArchivo(numeros, archivoSalida);
            System.out.println("\n Archivo generado exitosamente: " + archivoSalida);
        } else {
            System.out.println("No se pudo leer el archivo.");
        }  
    }

    // Aqui se crea la funcion para leer los numeros del archivo
    public static int[] leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int count = 0;

            // Primero se contaran cuántos números hay
            while ((linea = br.readLine()) != null) {
                count++;
            }

            int[] numeros = new int[count];
            br.close();
    }
}
