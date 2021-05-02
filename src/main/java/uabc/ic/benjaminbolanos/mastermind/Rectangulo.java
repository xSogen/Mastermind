package uabc.ic.benjaminbolanos.mastermind;

import java.awt.Rectangle;

/**
 * Clase para dibujar un rectangulo
 * @author Benjamin Bolaños
 * @version 2021.04.26
 */
public class Rectangulo {
    private int base;
    private int altura;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private Canvas canvas;
    
    public Rectangulo(int base, int altura, int xPosition, int yPosition, String color, Canvas canvas){
        this.base=base;
        this.color=color;
        this.canvas=canvas;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.altura=altura;
    }
    
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
    
    private void draw()
    {
        if(isVisible) {
            canvas.draw(this, color,
                        new Rectangle(xPosition, yPosition, base,altura));
            canvas.wait(10);
        }
    }
    
    private void erase()
    {
        if(isVisible) {
            canvas.erase(this);
        }
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
}