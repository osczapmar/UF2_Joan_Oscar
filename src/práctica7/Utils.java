/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica7;

import java.util.Scanner;

/**
 * Llibreria d'utilitats
 *
 * @author ÓscarZapateroMarchal
 *
 */
public class Utils {
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt()">

    private static Scanner scan = null;

    /**
     * Leer número entero llamando a la función LlegirInt(Scanner)
     *
     * @return número leido
     */
    public static int LlegirInt() {
        int result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirInt(scan);

        return result;
    }

    /**
     * Leer número entero llamando a la función LlegirInt(Scanner, String)
     * imprimiendo un mensaje determinado
     *
     * @param missatge mensaje impreso por pantalla
     * @return número leido
     */
    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null) {
            scan = new Scanner(System.in);
        }
        result = LlegirInt(scan, missatge);

        return result;
    }

    /**
     * Llamar función LlegirInt(Scanner, String) de lectura de número entero sin
     * imprimir mensaje
     *
     * @param scan
     * @return número entero leido
     */
    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }

    /**
     * Leer número entero entre un rango de valores
     *
     * @param scan
     * @param missatge mensaje impreso por pantalla
     * @param valorMin valor mínimo del rango de valores
     * @param valorMax valor máximo del rango de valores
     * @return número entero leido y comprendido entre un rango de valor
     */
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax) {
        int result = 0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);

        return result;
    }

    /**
     * Leer número entero
     *
     * @param scan
     * @param missatge mensaje impreso por pantall
     * @return número entero leido por consola
     */
    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }
    //LISTADO DE FORMATEADO Y COLOREADO POR CONSOLA

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    
    public static String LlegirString (String missatge) {
        String result;
        System.out.println(missatge);
        result = scan.nextLine();
        return result;
    }
    
    /**
     * Leer número entero por consola mostrando mensaje de error
     *
     * @param missatge mensaje mostrado al preguntar por el número
     * @return número leído por consola
     */
    public static int LlegirIntError(String missatge) {
        int result;

        System.out.println(missatge);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("No has introducido un número.");
            System.out.println(missatge);
        }
        result = scan.nextInt();

        return result;
    }

    /**
     * Comprobar que un número esté dentro de un rango establecido entre
     * valorMin y valorMax.
     *
     * @param missatge mensaje impreso
     * @param valorMin límite mínimo valor result
     * @param valorMax límite máximo valor result
     * @return número resultado de la lectura por consola
     */
    public static int IntoRange(String missatge, int valorMin, int valorMax) {
        int result = 0;
        do {
            result = LlegirInt(missatge);
        } while (result < valorMin || result > valorMax);

        return result;
    }

    /**
     * Imprimir un error
     *
     * @param mensaje mensaje impreso en formato de error
     */
    public static void MostrarError(String mensaje) {
        mensaje = RED + "ERROR: " + mensaje + RESET;
        System.out.println(mensaje);
    }

    /**
     * Obtener la media de un vector de enteros
     *
     * @param v vector de números enteros
     * @return valor medio
     */
    public static int MitjaInt(int[] v) {
        int m, sum;
        sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += v[i];
        }
        m = sum / v.length;
        return m;
    }

    /**
     * Obtener la media de un vector de floats
     *
     * @param v vector de números float
     * @return valor medio
     */
    public static float MitjaFloat(float[] v) {
        float m, sum;
        sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += v[i];
        }
        m = sum / v.length;
        return m;
    }

    /**
     * Sumar dos valores
     *
     * @param a valor 1 a sumar
     * @param b valor 2 a sumar
     * @return resultado entero de la suma
     */
    public static int Suma(int a, int b) {
        int sum = a + b;
        return sum;
    }

    /**
     * Restar dos valores
     *
     * @param a valor 1 a restar
     * @param b valor 2 a restar
     * @return resultado entero de la resta
     */
    public static int Resta(int a, int b) {
        int resta = a - b;
        return resta;
    }

    /**
     * Multiplicar dos valores
     *
     * @param a valor 1 a multiplicar
     * @param b valor 2 a multiplicar
     * @return resultado entero de la multilplicación
     */
    public static int Multiplicar(int a, int b) {
        int mult = a * b;
        return mult;
    }

    /**
     * Dividir dos valores
     *
     * @param a valor 1 a dividir
     * @param b valor 2 a dividir
     * @return resultado entero de la multiplicación
     */
    public static int Dividir(int a, int b) {
        int div = a / b;
        return div;
    }

    /**
     * Sumar elementos de un array de enteros
     *
     * @param v array de enteros
     * @return resultado de la suma de los enteros del array
     */
    public static int suma_elementsInt(int[] v) {
        int sum;
        sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += v[i];
        }

        return sum;
    }

    /**
     * Multiplicar elementos de un array de enteros
     *
     * @param v
     * @return
     */
    public static int multiply_elementsInt(int[] v) {
        int mult;
        mult = 1;
        for (int i = 0; i < v.length; i++) {
            mult *= v[i];
        }

        return mult;
    }

    /**
     * Creación de array
     *
     * @param capacidad capacidad máxima del array
     * @return array completamente formado
     */
    public static int[] CrearArray(int capacidad) {
        int[] array = new int[capacidad];
        for (int i = 0; i < array.length; i++) {
            array[i] = LlegirInt("Valor de array nº" + i);
        }
        return array;
    }

    /**
     * Imprimir valores de un array
     *
     * @param array array de valores enteros a imprimir
     */
    public static void ImprimirArrayInt(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Creación de matriz
     *
     * @param filas número de filas de la matriz
     * @param columnas número de columnas de la matriz
     * @return matriz completamente formada
     */
    public static int[][] CrearMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = LlegirInt("Valor de matriz posición " + i + " " + j);
            }
        }
        return matriz;
    }

    /**
     * Imprimir valores de una matriz
     *
     * @param matriz matriz de valores enteros a imprimir
     */
    public static void ImprimirMatrizInt(int[][] matriz) {
        for (int i = 0; i < matriz.length; i--) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Metodo de ordenación por burbuja de arrays de manera ascendente
     *
     * @param array array a ordenar
     */
    public static void BubbleSortIntASC(int[] array) {
        boolean haycambios = true;
        for (int i = 0; i < array.length && haycambios == true; i++) {
            haycambios = false;
            int aux;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {

                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    haycambios = true;
                }
            }
        }
    }

    /**
     * Metodo de ordenación por burbuja de arrays de manera descendente
     *
     * @param array array a ordenar
     */
    public static void BubbleSortIntDESC(int[] array) {
        boolean haycambios = true;
        for (int i = 0; i < array.length && haycambios == true; i++) {
            haycambios = false;
            int aux;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {

                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    haycambios = true;
                }
            }
        }
    }

// </editor-fold>
}
