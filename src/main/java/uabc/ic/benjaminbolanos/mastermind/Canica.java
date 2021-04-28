
package uabc.ic.benjaminbolanos.mastermind;

import java.util.Objects;

/**
 *
 * @author Benjamin Bolaños
 * @version 2021.04.26
 */
public class Canica {
    private String color;
    private int tamano;

    public Canica(String color, int tamano) {
        this.color = color;
        this.tamano = tamano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
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

