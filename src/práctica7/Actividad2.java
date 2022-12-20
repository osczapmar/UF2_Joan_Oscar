package práctica7;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;
import static práctica7.Utils.*;

/**
 *
 * @author OscarZapateroMarchal/JoanGuerreroSanchez
 */
public class Actividad2 {

    /**
     * Formato fecha
     */
    final static String DATE_FORMAT = "dd-MM-yyyy";

    /**
     * Validar si una fecha es correcta
     *
     * @param date fecha a validar
     * @return
     */
    static Scanner scan = new Scanner(System.in);
    static DateFormat df = new SimpleDateFormat(DATE_FORMAT);
    
    public static boolean isDateValid(String date) {
        String errordate = "Fecha incorrecta, vuelve a intentarlo";
        boolean valid;
        try {
            df.setLenient(false);
            df.parse(date);
            valid = true;
        } catch (ParseException e) {
            MostrarError(errordate);
            valid = false;
        }
        return valid;
    }

    public static String AskString(String mensaje) {
        String texto;
        System.out.println(mensaje);
        texto = scan.next();
        return texto;
    }
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
    

    public static double CalcularIVA(double preu, String typeIva, Date fecha) throws ParseException {
        
        int pos;
        double preufinal = 0;
        double[] general = {0.12, 0.15, 0.15, 0.16, 0.18, 0, 21};
        double[] reduit = {0.06, 0.06, 0.06, 0.07, 0.08, 0, 1};
        double[] superreduit = {0, 0, 0.03, 0.04, 0.04, 0.04};
        final double exempt = 0;

        if (fecha.after(df.parse("01-01-1986")) && fecha.before(df.parse("01-01-1992")) || fecha.equals(df.parse("01-01-1986"))) {
            pos = 0;
            switch (typeIva) {
                case "General":
                    preufinal = preu + (preu * general[pos]);
                    break;
                case "Reduit":
                    preufinal = preu + (preu * reduit[pos]);
                    break;
                case "Superreduit":
                    preufinal = preu + (preu * superreduit[pos]);
                    break;
                case "Exempt":
                    preufinal = preu + (preu * exempt);
                    break;
            }
        } else if (fecha.after(df.parse("01-01-1992")) && fecha.before(df.parse("01-01-1993")) || fecha.equals(df.parse("01-01-1992"))) {
            pos = 1;
            switch (typeIva) {
                case "General":
                    preufinal = preu + (preu * general[pos]);
                    break;
                case "Reduit":
                    preufinal = preu + (preu * reduit[pos]);
                    break;
                case "Superreduit":
                    preufinal = preu + (preu * superreduit[pos]);
                    break;
                case "Exempt":
                    preufinal = preu + (preu * exempt);
                    break;
            }
        } else if (fecha.after(df.parse("01-01-1993")) && fecha.before(df.parse("01-01-1995")) || fecha.equals(df.parse("01-01-1993"))) {
            pos = 2;
            switch (typeIva) {
                case "General":
                    preufinal = preu + (preu * general[pos]);
                    break;
                case "Reduit":
                    preufinal = preu + (preu * reduit[pos]);
                    break;
                case "Superreduit":
                    preufinal = preu + (preu * superreduit[pos]);
                    break;
                case "Exempt":
                    preufinal = preu + (preu * exempt);
                    break;
            }
        } else if (fecha.after(df.parse("01-01-1995")) && fecha.before(df.parse("01-01-2010")) || fecha.equals(df.parse("01-01-1995"))) {
            pos = 3;
            switch (typeIva) {
                case "General":
                    preufinal = preu + (preu * general[pos]);
                    break;
                case "Reduit":
                    preufinal = preu + (preu * reduit[pos]);
                    break;
                case "Superreduit":
                    preufinal = preu + (preu * superreduit[pos]);
                    break;
                case "Exempt":
                    preufinal = preu + (preu * exempt);
                    break;
            }
        } else if (fecha.after(df.parse("01-01-2010")) && fecha.before(df.parse("15-07-2012")) || fecha.equals(df.parse("01-01-2010"))) {
            pos = 4;
            switch (typeIva) {
                case "General":
                    preufinal = preu + (preu * general[pos]);
                    break;
                case "Reduit":
                    preufinal = preu + (preu * reduit[pos]);
                    break;
                case "Superreduit":
                    preufinal = preu + (preu * superreduit[pos]);
                    break;
                case "Exempt":
                    preufinal = preu + (preu * exempt);
                    break;
            }
        } else if (fecha.after(df.parse("15-07-2012")) || fecha.equals(df.parse("15-07-2012"))) {
            pos = 5;
            switch (typeIva) {
                case "General":
                    preufinal = preu + (preu * general[pos]);
                    break;
                case "Reduit":
                    preufinal = preu + (preu * reduit[pos]);
                    break;
                case "Superreduit":
                    preufinal = preu + (preu * superreduit[pos]);
                    break;
                case "Exempt":
                    preufinal = preu + (preu * exempt);
                    break;
            }
        }

        return preufinal;
    }

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {

        String date, typeIVA;
        double preu, preufinal;
        boolean validDate, wrongCat;
        Date dateformat = null;
        date="";
        typeIVA = "";
        wrongCat = true;
        validDate = false;

        preu = LlegirDouble("Introduce el precio en bruto:");
        scan.nextLine();
        while (!(typeIVA.equals("General") || typeIVA.equals("Reduit")
                || typeIVA.equals("Superreduit") || typeIVA.equals("Exempt"))) {
            if (wrongCat == false) {
                MostrarError("La opción no está dentro del rango de tipos");
            }
            typeIVA = AskString("Introduce el tipo de IVA aplicado:\nGeneral\nReduit\nSuperreduit\nExempt ");
            wrongCat = false;
        }
    
    while (!validDate) {
            date = AskString("Introduce la fecha de compra: ");
        validDate = isDateValid(date);
        dateformat = new SimpleDateFormat(DATE_FORMAT).parse(date);
        if (dateformat.before(df.parse("01-01-1986"))) {
            MostrarError("Fecha no disponible");
            validDate = false;
        }

    }

    preufinal  = CalcularIVA(preu, typeIVA, dateformat);

    System.out.println (

    "Data inici de vigència: " + date);
    System.out.println (

    "Precio base: " + preu);
    System.out.println (

    "Tipo de IVA: " + typeIVA);
    System.out.println (

"Precio final: " + preufinal);
    }

}
