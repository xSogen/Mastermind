
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
    
    public Texto(String contenido, int tamaño){
        this.contenido=contenido;
        this.tamaño=tamaño;
        Font font1 = new Font("Courier", Font.BOLD, tamaño);
        FontRenderContext frc=new FontRenderContext(null, false, false);
        
    }
    
    public void imprimir(int posX, int posY, Canvas canvas){
        TextLayout texto=new TextLayout(contenido,font1,frc);
        texto.draw(canvas.getGraphic(),posX,posY);
    }
    
    
}
