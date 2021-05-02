
package uabc.ic.benjaminbolanos.mastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que controla la parte logica del juego Mastermind
 * Para apartado grafico vea la clase MastermindGrafico
 * @author Benjamin Bolaños
 * @version 2021.05.02
 */
public class MastermindLogico {
    private ArrayList<Canica> respuesta; //ArrayList para guardar la respuesta
    private TableroLogico tablero;       //Instancia de TableroLogico
    private int tamañoDeJuego;           //Cantidad de canicas de la respuesta
    private int turno=0;                 //Contador de turnos
    private int [] aciertos;             //2 para posicion, 1 para color y 0 para nada
    private final String codigoColores[] = {"AZ", "AM", "RO", "NE", "CA", "NA", "MO", "BL"};    //Codigo de los colores posibles
    
    /**
     * Metodo constructor
     * @param tamañoDeJuego Recibe la cantidad de canicas de la respuesta 
     */
    public MastermindLogico(int tamañoDeJuego){
        this.tamañoDeJuego=tamañoDeJuego;
        respuesta=new ArrayList(tamañoDeJuego);
        tablero=new TableroLogico(15);  //Se dice que siempre habra 15 oportunidades
        aciertos= new int[tamañoDeJuego]; 
    }
    
    /**
     * Metodo que crea 'tamañoDeJuego' canicas y las mete en el ArrayList respuesta.
     * Las canicas pueden ser duplicadas.
     */
    public void crearRespuesta() {
        for (int i = 0; i < tamañoDeJuego; i++) {
            //Añade una Canica que crea a partir de un color random.
            respuesta.add(new Canica(codigoRandom()));
        }
    }

    /**
     * Metodo que crea 'tamañoDeJuego' canicas y las mete en el ArrayList respuesta.
     * Las canicas no pueden ser duplicadas.
     */
    public void crearRespuestaSD() {
        //El ciclo corre mientras 'respuesta' no este lleno.
        while (respuesta.size() < tamañoDeJuego) {
            String color = codigoRandom();      //Crea un codigo random
            Canica canica = new Canica(color); //Se crea una canica con el codigo random
            boolean duplicado = false;         //Booleano que inicia en falso, determinara si la canica es duplicada

            /*
                Ciclo foreach para cada canica dentro de respuesta.
                Para cada canica de respuesta se comparara la nueva
                canica creada. Si se encuentra que hay dos iguales y se marcara
                como duplicada.
            */
            for (Canica can : respuesta) {
                if (canica.getColor().equals(can.getColor()))
                    duplicado = true;
            }

            //Si la canica no es marcada como duplicada, se añadira al ArrayList de respuesta
            if (!duplicado) respuesta.add(canica);
        }
    }
    
    /**
     * Metodo que retorna un codigo de una posicion random de los codigos posibles
     *
     * @return String con el codigo de una posicion aleatoria
     */
    public String codigoRandom() {
        Random random = new Random();
        int num = random.nextInt(8);
        return codigoColores[num];
    }
    
    /**
     * Metodo para ingresar una combinacion de tamañoDeJuego canicas
     * Se ingresa el codigo del color y con eso se crea la canica y se añade 
     * a un ArrayList.
     * 
     * Si la combinacion no existe anteriormente, se añade a Tablero y retorna true
     * @return True si la combinacion se añadio y no es repetida
     */
    public boolean ingresarCombinacion(){
        Scanner scan= new Scanner(System.in);
        ArrayList<Canica> combinacion=new ArrayList(tamañoDeJuego);
        System.out.println("Codigos de Colores: AZ, AM, RO, NE, CA, NA, MO, BL");
        System.out.println("Ingrese canicas: ");
        for(int i=0;i<tamañoDeJuego;i++){
            System.out.println("Canica "+(i+1)+":");
            Canica canica= new Canica(scan.nextLine());
            combinacion.add(canica);
        }
        
        boolean exito=tablero.añadirCombinacion(combinacion);
        if(exito){
            turno++;
        }
        return exito;
    }
    
    public ArrayList<Canica> mandarCombinacion(){
        return tablero.getTablero().get(turno-1);
    }
    
    public ArrayList<Canica> getRespuesta(){
        return respuesta;
    }
    
    /**
     * Metodo que calcula si la combinacion ingresada y la respuesta son iguales
     * Este caso es victoria por lo que retorna true en ese caso
     * @return True si hay victoria
     */
    public boolean victoria(){
        //Contador para ver cuantas canicas son iguales
        int canicasIguales=0;
        
        //Ciclo que corre tamañoDeJuego veces
        for(int i=0;i<tamañoDeJuego;i++){
            Canica resp=respuesta.get(i); //Canica en i de respuesta
            Canica comb=mandarCombinacion().get(i);//Canica en i de combinacion
            
            //Si los colores de ambas canicas son iguales, se incrementa en
            // uno el contador de canicasIguales
            if(resp.getColor().equals(comb.getColor())) canicasIguales++;
        }
        
        //Si las canicas iguales y el tamañoDeJuego son iguales entonces
        // tenemos victoria. por lo que se retorna true
        if(canicasIguales==tamañoDeJuego){
            return true;
        }
        else
            return false;
    }
    
    /**
     * Metodo para contar aciertos de la ultima combinacion ingresada
     * Cuenta los colores de la combinacion y los colores de la respuesta
     * y los compara para sacar cuantos colores son iguales.
     * 
     * Luego, cuenta cuantos colores y posiciones son iguales.
     * 
     * Con esos datos añade ya sea 2, 1 o 0 al array de aciertos.
     */
    public void contarAciertos(){
        //Se crea un contador para cada color de canica de combinacion
        int az=0,am=0,ro=0,ne=0,ca=0,na=0,mo=0,bl=0;
        
        //Contadores para colores de la respuesta
        int azR=0,amR=0,roR=0,neR=0,caR=0,naR=0,moR=0,blR=0;
        
        
        for(int i=0;i<tamañoDeJuego;i++){
            //Se cuentan los colores de la combinacion ingresada
            switch(mandarCombinacion().get(i).getCodigo()){
                case "AZ":
                    az++;
                    break;
                case "AM":
                    am++;
                    break;
                case "RO":
                    ro++;
                    break;
                case "NE":
                    ne++;
                    break;
                case "CA":
                    ca++;
                    break;
                case "NA":
                    na++;
                    break;
                case "MO":
                    mo++;
                    break;   
                case "BL":
                    bl++;
                    break;    
            }
            
            //Se cuentan los colores de la respuesta
            switch(respuesta.get(i).getCodigo()){
                case "AZ":
                    azR++;
                    break;
                case "AM":
                    amR++;
                    break;
                case "RO":
                    roR++;
                    break;
                case "NE":
                    neR++;
                    break;
                case "CA":
                    caR++;
                    break;
                case "NA":
                    naR++;
                    break;
                case "MO":
                    moR++;
                    break;
                case "BL":
                    blR++;
                    break;    
            }
        }
        
        //Se comparan los colores de combinacion con respuesta
        int colores=0,posiciones=0;
        colores+=comparar(az,azR);
        colores+=comparar(am,amR);
        colores+=comparar(ro,roR);
        colores+=comparar(ne,neR);
        colores+=comparar(ca,caR);
        colores+=comparar(na,naR);
        colores+=comparar(mo,moR);
        colores+=comparar(bl,blR);
            
        //Ciclo para saber cuantas canicas tienes el color y posicion correcto
        for(int i=0;i<tamañoDeJuego;i++){
            Canica resp=respuesta.get(i);
            Canica comb=mandarCombinacion().get(i);
            if(resp.getColor().equals(comb.getColor())) posiciones++;
        }
        
        //Ciclos para añadir valores en el array de acierto
        for(int i=0; i<posiciones;i++){
            aciertos[i]=2;
        }
        for(int i=posiciones; i<colores;i++){
            aciertos[i]=1;
        }
        for(int i=colores; i<tamañoDeJuego;i++){
            aciertos[i]=0;
        }
    }
    
    /**
     * Metodo privado para comparar colores de combinacion y respuesta
     * @param comb Cantidad de canicas con el color en combinacion
     * @param resp Cantidad de canicas con el color en respuesta
     * @return La cantidad de colores correctos que hay
     */
    private int comparar(int comb, int resp){
        int colores=0;
        if(comb>0 && resp>0){
                if(comb==resp) colores+=resp;
                else if(resp>comb) colores+=comb;
                else colores+=resp;
            }
        return colores;
    }

    public int[] getAciertos() {
        return aciertos;
    }

    public void setAciertos(int[] aciertos) {
        this.aciertos = aciertos;
    }
}