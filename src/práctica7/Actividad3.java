
package práctica7;

import java.util.Scanner;

/**
 *
 * @author ausias
 */
public class Actividad3 {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";  // RED

    public static void main(String[] args) {
        int numero = pedirnum("Ingresa un numero: ");
        System.out.println(Roman(numero));
    }
    public static int pedirnum(String a) {
        int num;
        Scanner s = new Scanner(System.in);
        System.out.print(a);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println(RED + "ERROR" + RESET);
            System.out.print(a);
        }
        num = s.nextInt();
        return num;
    }
        public static String Roman(int numero) {
            String respuesta;
        //Se crean vectores con millares, centenas, decenas y unidades
        String[] millares = {"", "M", "MM", "MMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //Si está fuera del rango lo dirá
        if (numero <= 0 || numero >= 4000) {
            respuesta= "Fuera de los limites";
        } else {
        //Se comprueba si tiene unidades de mil, si tiene centenas, decenas 
        //y unidades para asignar un valor de los vectores
            respuesta= millares[numero / 1000] + centenas[(numero % 1000) / 100] + decenas[(numero % 100) / 10] + unidades[numero % 10];
        }
        return respuesta;
    }

    
}
