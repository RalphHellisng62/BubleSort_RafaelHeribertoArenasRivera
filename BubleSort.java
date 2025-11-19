import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

             //  Aqui vuelve a leer nuevamente para guardar los datos
            BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivo));
            int i = 0;
            while ((linea = br2.readLine()) != null) {
                numeros[i] = Integer.parseInt(linea.trim());
                i++;
            }
            br2.close();

            return numeros;

        } catch (IOException | NumberFormatException e) {
            System.out.println("⚠ Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

     // Construcción del algoritmo BubbleSort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    // El intercambio de valores
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambio = true;
                }
            }

            if (!intercambio) break; // Ojo! si no hubo intercambio, el array ya está ordenado
        }
    }

     // Esto imprime el arreglo
    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
