
package práctica7;
import java.util.Scanner;
import static práctica7.Utils.*;
/**
 *
 * @author ausias
 */
public class Actividad4 {
    
    static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static boolean ValidarSuperusuari () {
        boolean acierto = false;
        final String superpwd = "Argentina#2022!";
        int intentos = 3;
        String mensajeintento;
        String EnterPWD = "Introduce una contraseña: ";
        String pwd;
        
        while (intentos >0 && acierto == false) {
            mensajeintento = "Te quedan " + intentos + " intentos";
            System.out.println(mensajeintento);
            System.out.println(EnterPWD);
            pwd = scan.nextLine();
            if (pwd.equals(superpwd)) {
                acierto = true;
            }
            intentos--;
        }
        return acierto;
    }
    public static void main(String[] args) {
        
        boolean pwdtrue;
        pwdtrue = ValidarSuperusuari();
        
        if (pwdtrue == false) {
            System.out.println("¡Número de intentos sobrepasado!, vuelve a intentarlo en otro momento");
        }
        else {
            System.out.println("Iniciando sistema...");
        }
            
        
        
    }
    
}
