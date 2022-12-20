package práctica7;

import java.util.Scanner;

/**
 *
 * @author OscarZapateroMarchal/JoanGuerreroSanchez
 */
public class Actividad1 {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";     // RED
    
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
     * Leer número double por consola
     *
     * @param missatge mensaje mostrado al preguntar por el número
     * @return número leído por consola
     */
    public static double LlegirDouble(String missatge) {
        double result;

        System.out.println(missatge);
        while (!scan.hasNextDouble()) {
            scan.next();
            System.out.println("No has introducido un número.");
            System.out.println(missatge);
        }
        result = scan.nextDouble();

        return result;
    }
    
    /**
     * Recalcular precios descontando según la categoría de los productos
     * @param preu precio bruto
     * @param categoria categoria del producto
     * @return precio con descuento aplicado
     */
    public static double CalcularDescompte(double preu, String categoria) {
        double preciofinal= 0;
        final double descuentoA = 0.05;
        final double descuentoB = 0.1;
        final double descuentoCMenor = 0.2;
        final double descuentoCMayor = 0.35;
        switch (categoria) {
            case "A":
                preciofinal = preu - (preu * descuentoA);
                break;
            case "B":
                preciofinal = preu - (preu * descuentoB);
                break;
            case "C":
                if (preu < 100) {
                    preciofinal = preu - (preu * descuentoCMenor);
                }
                else {
                    preciofinal = preu - (preu * descuentoCMayor);
                }
        }
        return preciofinal;
    }
    
    public static String AskCategory (String mensaje) {
        String categoria;
        System.out.println(mensaje);
        categoria = scan.next().toUpperCase();
        return categoria;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String categoria="";
        double preu, preufinal;
        boolean wrongCat = true;
        
        preu = LlegirDouble("Qué precio tiene el producto elegido: ");
        scan.nextLine();
        while (!(categoria.equals("A") || categoria.equals("B") ||categoria.equals("C"))) {
            if (wrongCat==false) {
                MostrarError("La opción no está dentro del rango de categorías");
            }
            categoria = AskCategory("Introduce la categoría del producto: ");
            wrongCat = false;
        }
        preufinal = CalcularDescompte (preu, categoria);
        System.out.println("El precio final es de "+preufinal);
        
    }

}
