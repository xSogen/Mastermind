
package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author Benjamin Bolaños
 */
public class TableroGrafico {
    private ArrayList<Circle> espaciosVacios;
    private Rectangulo baseTablero;
    
    public TableroGrafico(int tamañoDeJuego, Canvas canvas){
        
        espaciosVacios=new ArrayList(tamañoDeJuego*15);
        baseTablero=new Rectangulo(300,850,350,100,"brown",canvas);
        baseTablero.makeVisible();
        mostrarTablero(tamañoDeJuego,canvas);
    }
    
    public void mostrarTablero(int tamañoDeJuego, Canvas canvas){
        int posX=405,posY=200,movX=0,movY=0;
        if(tamañoDeJuego==6) posX=355;
        
        //Muestra los espacios para canicas grandes
        for(int i=0; i<tamañoDeJuego;i++){
            for(int j=0;j<15;j++){
                Circle circle=new Circle(40,posX+movX,posY+movY,"gray",canvas);
                circle.makeVisible();
                movY+=50;
            }
            movX+=50;
            movY=0;
        }
        
        //Muestra los espacios para canicas pequeñas(aciertos)
        for(int i=0; i<tamañoDeJuego/2;i++){
            for(int j=0;j<2;j++){
                
            }
        }
    }
}
