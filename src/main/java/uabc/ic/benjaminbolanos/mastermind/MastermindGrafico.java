
package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Clase que controla la parte grafica del juego Mastermind
 * Para apartado logico vea la clase MastermindLogico
 * @author Benjamin Bolaños
 * @version 2021.05.02
 */
public class MastermindGrafico {
    private static Canvas canvas;
    private TableroGrafico tablero;
    private final String [] colores={"blue","yellow","red","black","brown","orange","magenta","white"};
    private int tamañoDeJuego;
    private int turno=0;
    
    /**
     * Metodo constructor
     * Crea una instancia Canvas
     * Crea una instancia de TableroLogico
     * @param tamañoDeJuego Recibe la cantidad de canicas de respuesta
     */
    public MastermindGrafico(int tamañoDeJuego){
        canvas=new Canvas("MASTERMIND",1000,1000,new Color(243,222,165));
        
        tablero=new TableroGrafico(tamañoDeJuego);
        this.tamañoDeJuego=tamañoDeJuego;
    }
    
    /**
     * Metodo para mostrar graficamente los posibles colores a un costado
     */
    public void mostrarColores(){
        int posX=15,posY=350;
        for(String color:colores){
            Circle circle=new Circle(30,posX,posY,color,canvas);
            circle.makeVisible();
            posY+=40;
        }
    }
    
    /**
     * Metodo que recibe un ArrayList con la respuesta y la imprime
     * @param respuesta ArrayList de canicas que es la respuesta
     */
    public void imprimirRespuesta(ArrayList<Canica> respuesta){
        int xPos, yPos, movX=0;
        //Dependiendo del tamaño del juego, es en la posicion donde se mostrara
        if(tamañoDeJuego==4){
            xPos=405;
            yPos=155;
        }
        else{
            xPos=355;
            yPos=155;
        }
        
        //Para cada canica de respuesta se crea un circulo del color de canica
        // y se hace visible
        for(Canica canica:respuesta){
            String color=canica.getColor();
            Circle circle=new Circle(40,xPos+movX,yPos,color,canvas);
            circle.makeVisible();
            movX+=50;
        }
    }
    
    /**
     * Metodo que recibe un ArrayList de Canica y pinta por cada canica
     * un Circle de su color utilizando el metodo pintarCanica de TableroGrafico
     * @param combinacion ArrayList de Canica con la combinacion a pintar
     */
    public void pintarCombinacion(ArrayList<Canica> combinacion){
        for(Canica canica:combinacion){
            tablero.pintarCanica(turno, combinacion.indexOf(canica), canica.getColor());
        }
        turno++;
    }
    
    /**
     * Metodo que muestra graficamente los aciertos del jugador
     * @param aciertos Array de enteros con la informacion de los aciertos
     */
    public void mostrarAciertos(int[] aciertos){
        //Ciclo que corre 'tamañoDeJuego' veces
        for(int i=0;i<tamañoDeJuego;i++){
            //Si aciertos en i es 2, el acierto se pinta de rojo
            if(aciertos[i]==2) tablero.pintarAcierto(turno-1,i,"red");
            //Si aciertos en i es 1, el acierto se pinta de blanco
            else if(aciertos[i]==1) tablero.pintarAcierto(turno-1,i,"white");
        }
    }

    public static Canvas getCanvas() {
        return canvas;
    }
    
    /**
     * Metodo que muestra todo el ambiente grafico del juego
     */
    public void imprimirJuego(){
        canvas.setVisible(true);
        tablero.mostrarTablero(tamañoDeJuego);
    }
    
}
