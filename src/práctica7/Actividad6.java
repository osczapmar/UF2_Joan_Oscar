
package práctica7;
import java.util.Scanner;
import static práctica7.Utils_1.pedirnumE;
public class Actividad6 {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";  // RED
    static Scanner s = new Scanner(System.in);
    static int[] pila = new int[10];
    public static void main(String[] args) {
        OpcionesPila();
    }
        public static void OpcionesPila() {
        int opcion;
        int posicion = 0;
        int numero;
        //Muestra menu con las opciones a elegir
        do {
            System.out.println("Opciones: ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Mostrar");
            System.out.println("4. Salir");
            while (!s.hasNextInt()) {
                System.out.println("¡Debes elegir una opción valida!");
                System.out.println("");
                System.out.println("Opciones: ");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Mostrar");
                System.out.println("4. Salir");
                s.next();
            }
            opcion = s.nextInt();
            //Segun la opcion elegida se hace una acción
            switch (opcion) {
                case 1://Push                    
                    if (posicion > 9) {//si tiene 10 valores no se podrán poner valores
                        System.out.println(RED + "¡Pila llena!" + RESET);
                        System.out.println("No se pueden poner valores");
                    } else {//caso contrario te pide el numero a añadir
                        numero = pedirnumE("Número a añadir: ");
                        pila[posicion] = numero;
                        posicion++;
                    }
                    break;
                case 2://Pop
                    if (posicion < 0 || posicion - 1 < 0) {//Si esta en la ultima posicion no se podrán quitar valores
                        System.out.println(RED + "¡Pila vacia!" + RESET);
                        System.out.println("No se pueden quitar valores");
                    } else {//caso contrario se quita el ultimo valor agregado
                        System.out.println("Número quitado: " + pila[posicion - 1]);//Se muestra el numero a quitar
                        pila[posicion - 1] = 0;
                        posicion--;

                    }
                    break;
                case 3://Mostrar
                    for (int i = pila.length - 1; i >= 0; i--) {
                        System.out.print(pila[i] + " ");
                    }
                    System.out.println("");
                    break;
                case 4://Salir
                    System.out.println("¡Gracias!");
                    break;
            }
        } while (opcion != 4);
    }
    
}
