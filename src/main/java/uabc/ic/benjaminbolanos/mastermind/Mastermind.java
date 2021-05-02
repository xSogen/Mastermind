/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabc.ic.benjaminbolanos.mastermind;

import java.util.Scanner;

/**
 * Clase que contiene el metodo main
 * En esta clase se ejecuta el juego Mastermind y se juntan las instancias
 * MastermindLogico y MastermindGrafico
 * @author Benjamin Bolaños
 * @version 2021.05.02
 */
public class Mastermind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String continuar = ""; //Variable que servira para saber si quiere jugar de nuevo
        do {
            int tamañoDeJuego; //Cantidad de canicas de la respuesta
            Scanner scan = new Scanner(System.in);
            System.out.println("Bienvenid@ a MASTERMIND.\n\n"
                    + "Comencemos configurando su juego:"
                    + "Tamaño de juego(4/6): ");
            
            //Para evitar problemas:
                //Si ingresa 6 o mas, el juego es de 6
                //Si ingresa menos de 6, el juego es de 4
            if (scan.nextInt() >= 6) {
                tamañoDeJuego = 6;
            } else {
                tamañoDeJuego = 4;
            }
            
            //Se limpia el buffer
            scan.nextLine();
            
            //Se pregunta e ingresa si quiere jugar con duplicados
            System.out.println("Respuesta con duplicados(Si/No): ");
            String conDuplicados = scan.nextLine().toLowerCase();
            
            //Se crean instancias de MastermindGrafico y MastermindLogico
            MastermindGrafico mg = new MastermindGrafico(tamañoDeJuego);
            MastermindLogico ml = new MastermindLogico(tamañoDeJuego);
            
            //Se crea la respuesta dependiendo si la quiere con duplicados
            if (conDuplicados.equals("si")) {
                ml.crearRespuesta();
            } else {
                ml.crearRespuestaSD();
            }
            
            //Se imprime todo el ambiente grafico
            mg.imprimirJuego();
            
            //Variable que nos dira si hay victoria o no
            boolean victoria=false;
            
            //Ciclo de las 15 oportunidades para atinar la respuesta
            for(int i=0;i<15;i++){
                //Se muestran los posibles colores
                mg.mostrarColores();
                //Metodo para ingresar una combinacion
                ml.ingresarCombinacion();
                //Metodo para pintar la combinacion que se ingreso anteriormente
                mg.pintarCombinacion(ml.mandarCombinacion());
                //Metodo para contar los aciertos de la combinacion
                ml.contarAciertos();
                //Se muestran los aciertos
                mg.mostrarAciertos(ml.getAciertos());
                //Se guarda en la variable si hay victoria o no
                victoria=ml.victoria();
                //Si hay victoria el ciclo se acaba
                if(victoria) break;
            }
            
            //Se muestra un mensaje dependiendo de si hubo victoria
            if(victoria) System.out.println("FELICIDADES! VICTORIA!");
            else System.out.println("SUERTE LA PROXIMA!");
            
            //Se imprime graficamente la respuesta
            mg.imprimirRespuesta(ml.getRespuesta());

            //Se pregunta si quiere jugar de nuevo
            System.out.println("¿Jugar de nuevo?(Si/No)");
            continuar = scan.nextLine().toLowerCase();
            
        //El ciclo del juego completo continua mientras se quiera seguir jugando
        } while (continuar.equals("si"));
    }

}
