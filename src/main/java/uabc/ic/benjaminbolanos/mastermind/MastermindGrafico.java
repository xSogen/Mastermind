
package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

/**
 *
 * @author Benjamin Bolaños
 */
public class MastermindGrafico {
    private static Canvas canvas;
    private TableroGrafico tablero;
    private final String colores[]={"blue","yellow","red","black","brown","orange","magenta","white"};
    private String codigoColores[] = {"AZ", "AM", "RO", "NE", "CA", "NA", "MO", "BL"};
    
    
    public MastermindGrafico(int tamañoDeJuego){
        canvas=new Canvas("Mastermind",1000,1000,new Color(243,222,165));
        canvas.setVisible(true);
        tablero=new TableroGrafico(tamañoDeJuego,canvas);
        mostrarColores();
        //dibujarTexto("MASTERMIND",400,40,40);
    }
    
    
    
    public void mostrarColores(){
        int posX=10,posY=800;
        for(String color:colores){
            Circle circle=new Circle(20,posX,posY,color,canvas);
            circle.makeVisible();
            posY+=25;
        }
        posX=35;
        posY=817;
        canvas.setForegroundColor("black");
        for(String codigo:codigoColores){
            //dibujarTexto(codigo,posX,posY,20);
            posY+=25;
        }
    }

    public static Canvas getCanvas() {
        return canvas;
    }
    
    
}
