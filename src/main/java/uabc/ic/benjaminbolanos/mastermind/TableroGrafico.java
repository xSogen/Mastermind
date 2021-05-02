
package uabc.ic.benjaminbolanos.mastermind;

/**
 * Clase para el tablero, pero solo sus procesos grafico
 * Para procesos logicos, vea la clase TableroLogico
 * @author Benjamin Bolaños
 * @version 2021.05.02
 */
public class TableroGrafico {
    
    private Rectangulo baseTablero;
    private Circle [][] canicas;
    private Circle [][] aciertos;
    
    /**
     * Metodo constructor que crea matrices de circulos para simular las canicas
     * @param tamañoDeJuego Cantidad de canicas en respuesta
     */
    public TableroGrafico(int tamañoDeJuego){
        canicas=new Circle[15][tamañoDeJuego];
        aciertos=new Circle[15][tamañoDeJuego];
        baseTablero=crearTabla(tamañoDeJuego);
    }
    
    /**
     * Metodo para mostrar todos los lugares de las canicas, aciertos 
     * y la tabla de madera.
     * @param tamañoDeJuego Cantidad de canicas en la respuesta
     */
    public void mostrarTablero(int tamañoDeJuego){
        int posX=405,posY=900,movX=0,movY=0;
        //se hace visible la base del tablero
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
        posY=902;
        
        if(tamañoDeJuego==6) posX=660;
        
        for(int i=0; i<15;i++){
            movX=0;
            for(int j=0;j<tamañoDeJuego;j++){
                if(j==tamañoDeJuego/2){
                    movX=0;
                    movY-=20;
                }
                Circle circle=new Circle(16,posX+movX,posY-movY,"gray",MastermindGrafico.getCanvas());
                circle.makeVisible();
                aciertos[i][j]=circle;
                movX+=20;
            }
            movY+=70;
        }
    }
    
    /**
     * Metodo que crea un rectangulo que simula la tabla de madera 
     * @param tamañoDeJuego Cantidad de canicas de la respuesta
     * @return Instancia de Rectangulo que seria la tabla de madera
     */
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
        return new Rectangulo(base, altura, xPos, yPos, "tabla", MastermindGrafico.getCanvas());
    }
    
    /**
     * Metodo para pintar una canica en cierta posicion
     * Cambia el color del circulo en cuestion
     * @param fila Fila donde se encuentra el circulo/canica
     * @param columna Columna donde se encuentra el circulo/canica
     * @param color Color al cual se cambiara el circulo/canica
     */
    public void pintarCanica(int fila, int columna, String color){
        canicas[fila][columna].changeColor(color);
    }
    
    /**
     * Metodo que pinta un circulo de aciertos, cambiandole el color
     * @param fila Fila donde se encuentra el acierto/circulo
     * @param columna Columna donde se encuentra el acierto/circulo
     * @param color Colo al cual se cambiara el acierto/circulo
     */
    public void pintarAcierto(int fila, int columna, String color){
        aciertos[fila][columna].changeColor(color);
    }
}
