
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
     * Comprobar contraseña en un máximo de 3 intentos
     * @return true si contraseña ha sido acertada/false si contraseña no ha sido acertada en ninguno de los intentos
     */
    public static boolean ValidarSuperusuari () {
        boolean acierto = false;
        final String superpwd = "Argentina#2022!"; //Contraseña superusuario
        int intentos = 3; //Numero de intentos
        String mensajeintento; //String intentos restantes
        String EnterPWD = "Introduce una contraseña: "; //String mensaje pedir contraseña
        String pwd; //Constraseña a introducir
        
        while (intentos >0 && acierto == false) { //Si te quedas sin intentos o aciertas termina
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
    /**
     * @param args the command line arguments
     */
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
