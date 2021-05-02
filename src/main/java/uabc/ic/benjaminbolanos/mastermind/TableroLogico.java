
package uabc.ic.benjaminbolanos.mastermind;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Clase para el tablero, pero solo sus procesos logicos.
 * Para lo grafico vea la clase TableroGrafico
 * @author Benjamin Bolaños
 * @version 2021.05.02
 */
public class TableroLogico {
    private HashSet<ArrayList<Canica>> tableroAux; //HashSet de ArrayLists de Canica, lugares del tablero
    private ArrayList<ArrayList<Canica>> tablero;


    /**
     * Metodo constructor
     * @param oportunidades La cantidad de oportunidades para atinar el resultado 
     */
    public TableroLogico(int oportunidades) {
        tableroAux = new HashSet(oportunidades);
        tablero = new ArrayList(oportunidades);
    }

    public HashSet<ArrayList<Canica>> getTableroAux() {
        return tableroAux;
    }

    public void setTableroAux(HashSet<ArrayList<Canica>> tableroAux) {
        this.tableroAux = tableroAux;
    }
    
    public ArrayList<ArrayList<Canica>> getTablero(){
        return tablero;
    }
    
    public void setTablero(ArrayList<ArrayList<Canica>> tablero){
        this.tablero=tablero;
    }

    /**
     * Metodo para añadir una combinacion y comprobar que no sea repetida
     *
     * @return True si la combinacion se añadio con exito y no es repetida
     */
    public boolean añadirCombinacion(ArrayList<Canica> combinacion) {
        boolean exito = false;  //Booleano que nos dice si hubo exito al añadir la combinacion a tablero
        exito = tableroAux.add(combinacion);
        if (exito) tablero.add(combinacion);
        return exito;
    }
}
