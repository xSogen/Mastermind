
package uabc.ic.benjaminbolanos.mastermind;

/**
 *
 * @author Benjamin Bolaños
 */
public class Feedback {

    public static void agregarCombinacion(boolean combinacionNoDuplicada){
        if(combinacionNoDuplicada)
            System.out.println("Combinacion ingresada exitosamente.");
        else
            System.out.println("Combinacion repetida.");
    }
}
