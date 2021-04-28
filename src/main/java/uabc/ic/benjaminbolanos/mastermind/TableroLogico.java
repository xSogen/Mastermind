
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
    private HashSet<ArrayList> tablero;
    private ArrayList<Canica> respuesta;
    private int aciertos[]; //0 para incorrecto, 1 para color correcto, 2 para posicion correcta
    private final String color[] = {"AZ", "AM", "RO", "NE", "CA", "NA", "MO", "BL"};
    private int tamañoDeJuego;


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

    public void crearRespuesta(){
        for (int i = 0; i<tamañoDeJuego; i++){
            respuesta.add(new Canica(colorRandom(),1));
        }
    }
    public void crearRespuestaSD(){
        while (respuesta.size()<tamañoDeJuego){
            String color = colorRandom();
            Canica canica = new Canica(color,1);
            boolean duplicado = false;
            for(Canica can : respuesta){
                if(canica.getColor() == can.getColor())
                    duplicado = true;
            }
            if(!duplicado) respuesta.add(canica);
        }
    }

    public boolean ingresarCombinacion(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Canica> combinacion = new ArrayList();
        for(int i = 0; i < tamañoDeJuego; i++){
            System.out.print("Introduzca la combinacion: ");
            combinacion.add(new Canica(sc.nextLine(),1));
        }
        boolean exito=false;
        if(!comprobarCombinacion(combinacion)){
            tablero.add(combinacion);
            exito=true;
        }
        return exito;
    }

    /**
     * Metodo que recibe un ArrayList y lo compara con los demas ArrayList de tablero.
     * @param al Recibe un ArrayList de Canica que es la combinacion ingresada por el usuario
     * @return Retorna true si el ArrayList es duplicado.
     */
    public boolean comprobarCombinacion(ArrayList<Canica> al){
        boolean duplicado=false;
        int cont;
        for (ArrayList<Canica> tab : tablero) {
            cont = 0;
            for (int i = 0; i < tamañoDeJuego; i++) {
                Canica can1 = al.get(i);
                Canica can2 = tab.get(i);
                if (can1.getColor().equals(can2.getColor()))
                    cont++;
            }
            if (cont == tamañoDeJuego) duplicado = true;
        }
        return duplicado;

    }

    public String colorRandom(){
        Random random = new Random();
        int num = random.nextInt(8);
        return color[num];
    }
}
