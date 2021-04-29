
package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Bolaños
 */
public class MastermindGrafico {
    private static Canvas canvas;
    private TableroGrafico tablero;
    private final String colores[]={"blue","yellow","red","black","brown","orange","magenta","white"};
    private String codigoColores[]={"AZ", "AM", "RO", "NE", "CA", "NA", "MO", "BL"};
    private Circle [] respuesta;
    private int tamañoDeJuego;
    
    
    public MastermindGrafico(int tamañoDeJuego){
        canvas=new Canvas("MASTERMIND",1000,1000,new Color(243,222,165));
        canvas.setVisible(true);
        tablero=new TableroGrafico(tamañoDeJuego,canvas);
        this.tamañoDeJuego=tamañoDeJuego;
        respuesta= new Circle[tamañoDeJuego];
        mostrarColores();
        tablero.mostrarTablero(tamañoDeJuego);
        
    }
    
    public void mostrarColores(){
        int posX=10,posY=400;
        for(String color:colores){
            Circle circle=new Circle(20,posX,posY,color,canvas);
            circle.makeVisible();
            posY+=25;
        }
        posX=35;
        posY=417;
        canvas.setForegroundColor("black");
        for(String codigo:codigoColores){
            Texto codigoCol=new Texto(codigo,posX,posY,20);
            codigoCol.imprimir();
            posY+=25;
        }
    }
    
    public void mostrarTitulo(){
        Texto titulo=new Texto("MASTERMIND",400,40,40);
        titulo.imprimir();
    }
    
    public void imprimirRespuesta(ArrayList<Canica> respuesta){
        int xPos, yPos, movX=0;
        if(tamañoDeJuego==4){
            xPos=405;
            yPos=170;
        }
        else{
            xPos=355;
            yPos=170;
        }
        for(Canica canica:respuesta){
            Circle circle=new Circle();
        }
    }

    public static Canvas getCanvas() {
        return canvas;
    }
}
