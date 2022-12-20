package práctica7;

import java.text.Normalizer;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class Practica7UF2 {

    static DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static Scanner s = new Scanner(System.in);
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";  // RED
    static int[] pila = new int[10];

    public static void main(String[] args) {
        //Pruebas Ejercio1
        float precio1 = pedirnumF("Precio: ");
        System.out.print("Categoria: ");
        String cat = s.next();
        System.out.println("");
        System.out.println(String.format(java.util.Locale.ITALY, "%.2f", CalcularDescompte(precio1, cat)));
        //Pruebas Ejercicio2
        float precio = pedirnumF("Precio: ");
        String tipo = menu();
        int dia = pedirnum("Día: ");
        int mes = pedirnum("Mes: ");
        while (mes > 12) {
            System.out.println(RED + "Mes incorrecto" + RESET);
            mes = pedirnum("Mes: ");
        }
        int anyo = pedirnum("Año: ");
        LocalDate date1;
        try {
            date1 = LocalDate.of(anyo, mes, dia);
        } catch (Exception e) {
            LocalDate date2 = LocalDate.of(anyo, mes, 1);
            int dias = date2.lengthOfMonth();
            while (dia > dias) {
                System.out.println(RED + "Día incorrecto" + RESET);
                System.out.println("Rango de dias para el mes " + mes + ": " + dias);
                dia = pedirnum("Día:");
            }
        }
        date1 = LocalDate.of(anyo, mes, dia);
        System.out.println(CalcularIVA(precio, tipo, date1));
        //Pruebas Ejercicio3
        int numero = pedirnum("Ingresa un numero: ");
        System.out.println(Roman(numero));
        //Pruebas Ejercicio4
        System.out.println(ValidarSuperusuari());
        //Pruebas Ejercicio6
        OpcionesPila();
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

    public static float pedirnumF(String a) {
        float num;
        Scanner s = new Scanner(System.in);
        System.out.print(a);
        while (!s.hasNextFloat()) {
            s.next();
            System.out.println(RED + "ERROR" + RESET);
            System.out.print(a);
        }
        num = s.nextFloat();
        return num;
    }

    public static float CalcularDescompte(float precio, String categoria) {
        //Creamos los descuentos
        float ReducedPrice;
        float DesA = 0.95f;
        float DesB = 0.9f;
        float DesC;
        if (precio >= 100) {
            DesC = 0.65f;
        } else {
            DesC = 0.8f;
        }
        //Según la categoria entrará en un diferente case 
        //y si se ingresa un case no valido regresata el precio de 0
        switch (categoria.toUpperCase()) {
            case "A":
                ReducedPrice = precio * DesA;
                break;
            case "B":
                ReducedPrice = precio * DesB;
                break;
            case "C":
                ReducedPrice = precio * DesC;
                break;
            default:
                ReducedPrice = 0;
        }
        return ReducedPrice;
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

    public static String Roman(int numero) {
        //Se crean vectores con millares, centenas, decenas y unidades
        String[] millares = {"", "M", "MM", "MMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //Si está fuera del rango lo dirá
        if (numero <= 0 || numero >= 4000) {
            return "Fuera de los limites";
        } else {
        //Se comprueba si tiene unidades de mil, si tiene centenas, decenas 
        //y unidades para asignar un valor de los vectores
            return millares[numero / 1000] + centenas[(numero % 1000) / 100] + decenas[(numero % 100) / 10] + unidades[numero % 10];
        }
    }

    public static String ValidarSuperusuari() {
        final String PASSWORD = "ausias";
        boolean correct = false;
        String contrasenya;
        System.out.print("Ingresa contraseña: ");
        for (int i = 0, j = 2; i < 3 && !correct; i++, j--) {
            contrasenya = s.next();
            if (contrasenya.equals(PASSWORD)) {
                correct = true;
            } else if (!correct && i < 2) {
                System.out.println("Try again. " + j + " attempts remaining.");
            } else {
                System.out.println(j + " attempts remaining.");
            }
        }
        if (correct) {
            return "Acceso concedido";
        } else {
            return RED + "Acceso denegado" + RESET;
        }
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
                        numero = pedirnum("Número a añadir: ");
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
