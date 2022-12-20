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
 * @author author
 * @version version
 *
 */
public class Utils_1 {
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt()">

    private static Scanner scan=null;
       
    public static int LlegirInt() {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan);

        return result;
    }
    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan, missatge);
        
        return result;
    }

    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }
    
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax)
    {
        int result =0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);
        
        return result;
    }

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

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Implementació de Imprimir arrays()">
    /**
     * Imprime un vector de ints
     * @param a vector
     */
public static void vectorint(int[] a){
    for(int i=0;i<a.length;++i){
        System.out.print(a[i]+" ");
    }
    System.out.println("");
}
/**
 * Imprime un vector de doubles
 * @param a vector
 */
public static void vectordouble(double[] a){
    for(int i=0;i<a.length;++i){
        System.out.print(a[i]+" ");
    }
    System.out.println("");
}
/**
 * Imprime un vector de strings
 * @param a vector
 */
public static void vectorString(String[] a){
    for(int i=0;i<a.length;++i){
        System.out.print(a[i]+" ");
    }
    System.out.println("");
}
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Implementació de Imprimir matrices()">
/**
 * Imprime matrices tipo int
 * @param a Es la matriz a imprimir
 */
public static void matrizint(int[][] a){
    for(int i=0;i<a.length;++i){
        for(int j=0;j<a[i].length;++j){
            System.out.print(a[i][j]+" ");
        }
        System.out.println("");
    }
}
/**
 * Imprime matrices tipo double
 * @param a Es la matriz a imprimir
 */
public static void matrizdouble(double[][] a){
    for(int i=0;i<a.length;++i){
        for(int j=0;j<a[i].length;++j){
            System.out.print(a[i][j]+" ");
        }
        System.out.println("");
    }
}
/**
 * Imprime matrices tipo string
 * @param a Es la matriz a imprimir
 */
public static void matrizString(String[][] a){
    for(int i=0;i<a.length;++i){
        for(int j=0;j<a[i].length;++j){
            System.out.print(a[i][j]+" ");
        }
        System.out.println("");
    }
}
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Implementació de Pedir num(double)">
/**
 * Pide numeros tipo double
 * @param a Mensaje que quieres mostrar antes de pedir valores
 * @return 
 */
public static double pedirnumD(String a) {
        double num;
        Scanner s=new Scanner(System.in);
        System.out.print(a);
        while (!s.hasNextDouble()) {
            s.next();
            System.out.println("ERROR");
            System.out.print(a);
        }
        num = s.nextDouble();
        return num;
    }
public static int pedirnumE(String a) {
        int num;
        Scanner s=new Scanner(System.in);
        System.out.print(a);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("ERROR");
            System.out.print(a);
        }
        num = s.nextInt();
        return num;
    }
// </editor-fold>

}