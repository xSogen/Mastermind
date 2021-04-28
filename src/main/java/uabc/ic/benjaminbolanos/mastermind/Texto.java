
package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

/**
 *
 * @author Benjamin Bolaños
 */
public class Texto {
    private String contenido;
    private int tamaño;
    private FontRenderContext frc;
    private Font font1;
    private TextLayout textl;
    private int posX;
    private int posY;
    private Canvas canvas=MastermindGrafico.getCanvas();
    
    
    public Texto(String contenido, int posX, int posY, int tamaño){
        this.contenido=contenido;
        this.tamaño=tamaño;
        this.posX=posX;
        this.posY=posY;
        font1 = new Font("Courier", Font.BOLD, tamaño);
        frc=new FontRenderContext(null, false, false);
        textl=new TextLayout(contenido,font1,frc);
    }
    
    public void imprimir(){
        textl.draw(canvas.getGraphic(),posX,posY);
    }
    
    
}
