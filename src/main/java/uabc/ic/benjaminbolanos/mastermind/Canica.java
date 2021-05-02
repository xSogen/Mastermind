
package uabc.ic.benjaminbolanos.mastermind;

import java.util.Objects;

/**
 * Clase que modela una canica
 * 
 * @author Benjamin Bolaños
 * @version 2021.05.02
 */
public class Canica {
    private String color;
    private String codigo;

    /**
     * Metodo constructor que recibe el codigo
     * @param codigo Letras que ingresa el usuario(AZ AM RO etc)
     */
    public Canica(String codigo) {
        this.codigo = codigo;
        this.color=color();
    }
    
    /**
     * Metodo que dependiendo del codigo, va a retornar el color en ingles
     * para que se pueda crear graficamente la canica
     * @return El color en ingles
     */
    public String color(){
        String color="";
        
        switch(codigo){
            case "AZ":
                color="blue";
                break;
            case "AM":
                color="yellow";
                break;
            case "RO":
                color="red";
                break;
            case "NE":
                color="black";
                break;
            case "CA":
                color="brown";
                break;
            case "NA":
                color="orange";
                break;
            case "MO":
                color="magenta";
                break;
            case "BL":
                color="white";
                break;
        }
        return color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canica canica = (Canica) o;
        return Objects.equals(color, canica.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}

