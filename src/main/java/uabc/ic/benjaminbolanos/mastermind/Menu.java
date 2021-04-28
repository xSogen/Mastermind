
package uabc.ic.benjaminbolanos.mastermind;

/**
 *
 * @author Benjamin Bolaños
 */
public class Menu {
    private Rectangulo fondo;
    private Texto titulo;
    private String opciones[];
    
    public Menu(String[] opciones){
        this.opciones=opciones;
        fondo=new Rectangulo(1000,1000,0,0,"menu",MastermindGrafico.getCanvas());
        titulo=new Texto("MASTERMIND",280,350,80);
    }
    
    public void imprimirOpciones(){
        int movY=0;
        for(int i=0;i<opciones.length;i++){
            Texto texto=new Texto(opciones[i],400,500+movY,30);
            texto.imprimir();
            movY+=30;
        }     
    }
    
    public void imprimir(){
        fondo.makeVisible();
        MastermindGrafico.getCanvas().setForegroundColor("black");
        titulo.imprimir();
        imprimirOpciones();
    }
}
