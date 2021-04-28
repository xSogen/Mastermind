
package uabc.ic.benjaminbolanos.mastermind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Benjamin Bolaños
 */
public class TableroLogico {
    private HashSet<ArrayList> tablero;     //HashSet de ArrayLists de Canica, lugares del tablero
    private ArrayList<Canica> respuesta;    //ArrayList de Canica con la combinacion de la respuesta
    private int aciertos[];                 //0 para incorrecto, 1 para color correcto, 2 para posicion correcta
    private final String color[] = {"AZ", "AM", "RO", "NE", "CA", "NA", "MO", "BL"};    //Colores posibles
    private int tamañoDeJuego;              //Entero para saber cuantas canica habra


    public TableroLogico(int tamañoDeJuego, int oportunidades) {
        this.tamañoDeJuego = tamañoDeJuego;
        tablero = new HashSet(oportunidades);
        respuesta = new ArrayList(tamañoDeJuego);
        aciertos = new int[tamañoDeJuego];
    }

    public HashSet<ArrayList> getTablero() {
        return tablero;
    }

    public void setTablero(HashSet<ArrayList> tablero) {
        this.tablero = tablero;
    }

    public ArrayList<Canica> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(ArrayList<Canica> respuesta) {
        this.respuesta = respuesta;
    }

    public int[] getAciertos() {
        return aciertos;
    }

    public void setAciertos(int[] aciertos) {
        this.aciertos = aciertos;
    }

    /**
     * Metodo que crea 'tamañoDeJuego' canicas y las mete en el ArrayList respuesta.
     * Las canicas pueden ser duplicadas.
     */
    public void crearRespuesta(){
        for (int i = 0; i<tamañoDeJuego; i++){
            //Añade una Canica que crea a partir de un color random.
            respuesta.add(new Canica(colorRandom(),1));
        }
    }
    
    /**
     * Metodo que crea 'tamañoDeJuego' canicas y las mete en el ArrayList respuesta.
     * Las canicas no pueden ser duplicadas.
     */
    public void crearRespuestaSD(){
        //El ciclo corre mientras 'respuesta' no este lleno.
        while (respuesta.size()<tamañoDeJuego){
            String color = colorRandom();               //Crea un color random
            Canica canica = new Canica(color,1);        //Se crea una canica con el color random
            boolean duplicado = false;                  //Booleano que inicia en falso, determinara si la canica es duplicada
            
            /*
                Ciclo foreach para cada canica dentro de respuesta.
                Para cada canica de respuesta se comparara la nueva
                canica creada. Si se encuentra que hay dos iguales y se marcara
                como duplicada.
            */
            for(Canica can : respuesta){
                if(canica.getColor() == can.getColor())
                    duplicado = true;
            }
            
            //Si la canica no es marcada como duplicada, se añadira al ArrayList de respuesta
            if(!duplicado) respuesta.add(canica);
        }
    }

    /**
     * Metodo para ingresar una combinacion y comprobar que no sea repetida
     * @return True si la combinacion se añadio con exito y no es repetida
     */
    public boolean ingresarCombinacion(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Canica> combinacion = new ArrayList();        //ArrayList de la combinacion del usuario
        
        /*
            Ciclo que corre 'tamañoDeJuego' veces, para cada iteracion 
            creara una canica dependiendo del codigo ingresado. Las canicas
            creadas se añaden a combinacion.
        */
        for(int i = 0; i < tamañoDeJuego; i++){
            System.out.print("Introduzca la combinacion: ");
            combinacion.add(new Canica(sc.nextLine(),1));
        }
        
        boolean exito=false;                        //Booleano que nos dice si hubo exito al añadir la combinacion a tablero
        
        //Si la combinacion no es repetida, esta se añade al tablero y exito es true.
        if(!comprobarCombinacion(combinacion)){
            tablero.add(combinacion);
            exito=true;
        }
        return exito;
    }

    /**
     * Metodo que recibe un ArrayList y lo compara con los demas ArrayList de tablero.
     * @param combinacion Recibe un ArrayList de Canica que es la combinacion ingresada por el usuario
     * @return Retorna true si el ArrayList es duplicado.
     */
    public boolean comprobarCombinacion(ArrayList<Canica> combinacion){
        boolean duplicado=false;
        int cont;
        for (ArrayList<Canica> combinacionesTablero : tablero) {
            cont = 0;
            for (int i = 0; i < tamañoDeJuego; i++) {
                Canica can1 = combinacion.get(i);
                Canica can2 = combinacionesTablero.get(i);
                if (can1.getColor().equals(can2.getColor()))
                    cont++;
            }
            if (cont == tamañoDeJuego) duplicado = true;
        }
        return duplicado;
    }

    /**
     * Metodo que retorna un color de una posicion random de los colores posibles
     * @return String con el color de una posicion aleatoria
     */
    public String colorRandom(){
        Random random = new Random();
        int num = random.nextInt(8);
        return color[num];
    }
}
