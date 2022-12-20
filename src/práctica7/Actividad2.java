package práctica7;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.Scanner;

import static práctica7.Utils_1.*;
public class Actividad2 {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";  // RED
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        //Pruebas Ejercicio2
        float precio = pedirnumF("Precio: ");
        String tipo = menu();
        int dia = pedirnumE("Día: ");
        int mes = pedirnumE("Mes: ");
        while (mes > 12) {
            System.out.println(RED + "Mes incorrecto" + RESET);
            mes = pedirnumE("Mes: ");
        }
        int anyo = pedirnumE("Año: ");
        LocalDate date1;
        try {
            date1 = LocalDate.of(anyo, mes, dia);
        } catch (Exception e) {
            LocalDate date2 = LocalDate.of(anyo, mes, 1);
            int dias = date2.lengthOfMonth();
            while (dia > dias) {
                System.out.println(RED + "Día incorrecto" + RESET);
                System.out.println("Rango de dias para el mes " + mes + ": " + dias);
                dia = pedirnumE("Día:");
            }
        }
        date1 = LocalDate.of(anyo, mes, dia);
        System.out.println(CalcularIVA(precio, tipo, date1));
    }
    public static String menu() {
        int opcion;
        String tipo;
        do {
            System.out.println("Tipo: ");
            System.out.println("1. General");
            System.out.println("2. Reduït");
            System.out.println("3. Superreduït");
            System.out.println("4. Exempt");
            while (!s.hasNextInt()) {
                System.out.println("¡Debes elegir una opción valida!");
                System.out.println("");
                System.out.println("Tipo: ");
                System.out.println("1. General");
                System.out.println("2. Reduït");
                System.out.println("3. Superreduït");
                System.out.println("4. Exempt");
                s.next();
            }
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    tipo = "General";
                    break;
                case 2:
                    tipo = "Reduït";
                    break;
                case 3:
                    tipo = "Superreduït";
                    break;
                case 4:
                    tipo = "Exempt";
                    break;
                default:
                    tipo = "General";
            }
        } while (opcion > 4 || opcion < 1);
        return tipo;
    }
        public static float CalcularIVA(float precio, String tipo, LocalDate fecha) {
        float price;
        //Creamos las fechas de las diferentes vigencias
        LocalDate vigencia1 = LocalDate.of(1986, 1, 1);
        LocalDate vigencia2 = LocalDate.of(1992, 1, 1);
        LocalDate vigencia3 = LocalDate.of(1993, 1, 1);
        LocalDate vigencia4 = LocalDate.of(1995, 1, 1);
        LocalDate vigencia5 = LocalDate.of(2010, 1, 1);
        LocalDate vigencia6 = LocalDate.of(2012, 7, 15);
        String cadenaNormalize = Normalizer.normalize(tipo, Normalizer.Form.NFD);
        String tipos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");        
        if (fecha.isBefore(vigencia1)) {
            price = precio;//Si la fecha es antes de cualquier vigencia el precio no sera modificado
        } else {
            switch (tipos.toLowerCase()) {
            //Segun las categorias ponemos las diferentes condiciones de vigencia
                case "general":            
                    if (fecha.isBefore(vigencia2)) {
                        price = precio + (precio * 0.12f);
                    } else if (fecha.isBefore(vigencia3)) {
                        price = precio + (precio * 0.15f);
                    } else if (fecha.isBefore(vigencia4)) {
                        price = precio + (precio * 0.15f);
                    } else if (fecha.isBefore(vigencia5)) {
                        price = precio + (precio * 0.16f);
                    } else if (fecha.isBefore(vigencia6)) {
                        price = precio + (precio * 0.18f);
                    } else {
                        price = precio + (precio * 0.21f);
                    }
                    break;
                case "reduit":
                    if (fecha.isBefore(vigencia4)) {
                        price = precio + (precio * 0.06f);
                    } else if (fecha.isBefore(vigencia5)) {
                        price = precio + (precio * 0.07f);
                    } else if (fecha.isBefore(vigencia6)) {
                        price = precio + (precio * 0.08f);
                    } else {
                        price = precio + (precio * 0.1f);
                    }
                    break;
                case "superreduit":
                    if (fecha.isBefore(vigencia3)) {
                        price = precio;
                    } else if (fecha.isBefore(vigencia4)) {
                        price = precio + (precio * 0.03f);
                    } else {
                        price = precio + (precio * 0.04f);
                    }
                    break;
                default:
                    price = precio;
                    break;
            }
        }
        return price;
    }
    
}
