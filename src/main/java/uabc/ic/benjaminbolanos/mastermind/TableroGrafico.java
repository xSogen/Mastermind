
package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author Benjamin Bolaños
 */
public class TableroGrafico {
    
    private Rectangulo baseTablero;
    private Circle [][] canicas;
    
    public TableroGrafico(int tamañoDeJuego, Canvas canvas){
        canicas=new Circle[15][tamañoDeJuego];
        baseTablero=crearTabla(tamañoDeJuego);
        
    }
    
    public void mostrarTablero(int tamañoDeJuego){
        int posX=405,posY=900,movX=0,movY=0;
        baseTablero.makeVisible();
        if(tamañoDeJuego==6) posX=355;
        
        //Muestra los espacios para canicas grandes
        for(int i=0; i<tamañoDeJuego;i++){
            for(int j=0;j<15;j++){
                Circle circle=new Circle(40,posX+movX,posY-movY,"gray",MastermindGrafico.getCanvas());
                circle.makeVisible();
                movY+=50;
                canicas[j][i]=circle;
            }
            movX+=50;
            movY=0;
        }
        
        //Muestra los espacios para canicas pequeñas(aciertos)
        posX=605;
        posY=922;
        movX=0;
        if(tamañoDeJuego==6) posX=660;
        boolean brinco=false;
        for(int i=0; i<tamañoDeJuego/2;i++){
            for(int j=0;j<15*2;j++){
                Circle circle=new Circle(16,posX+movX,posY-movY,"gray",MastermindGrafico.getCanvas());
                circle.makeVisible();
                if(brinco) movY+=30;
                else movY+=20;
                brinco=!brinco;
            }
            movX+=20;
            movY=0;
        }
        Texto titulo=new Texto("MASTERMIND",400,40,40);
        titulo.imprimir();
        //canicas[0][0].changeColor("red");
    }
    
    public Rectangulo crearTabla(int tamañoDeJuego){
        int base, altura, xPos, yPos;
        if(tamañoDeJuego==4){
            base=260;
            altura=800;
            xPos=395;
            yPos=150;
        }else{
            base=380;
            altura=800;
            xPos=345;
            yPos=150;
        }
        return new Rectangulo(base, altura, xPos, yPos, "brown", MastermindGrafico.getCanvas());
    }
}
