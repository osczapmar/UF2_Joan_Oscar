package práctica7;

import java.util.Scanner;

/**
 *
 * @author OscarZapateroMarchal/JoanGuerreroSanchez
 */
public class Actividad5 {

    public static Scanner scan = new Scanner(System.in);
    
    public static void ImprimirArrayChar(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    
    public static void Titol(String text) {
      int posinici;
        int count = 0; //charAt text count one by one
        final int screenlength = 80;
        char[] screen = new char[screenlength];
        for (int i = 0; i < screen.length; i++) {
            screen[i] = ' '; //Llenar el array de espacios vacíos

        }
        posinici= (screenlength/2)-(text.length()/2);
        for (int i = 0; i < text.length(); i++) {
            screen[i+posinici] = text.charAt(count);
            count+=1;
        }
        ImprimirArrayChar(screen);
    }

    public static void main(String[] args) {
        String text;
        System.out.print("Introduce el título: ");
        text = scan.nextLine();
        Titol(text);
    }

}
