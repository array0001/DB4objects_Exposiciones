/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expo;

/**
 *
 * @author USERE
 */
public class Expositor {
    private String indentificacion;
    private String nombre;
    private String email;
    private float ganancia;

    public Expositor(String indentificacion, String nombre, String email, float ganancia) {
        this.indentificacion = indentificacion;
        this.nombre = nombre;
        this.email = email;
        this.ganancia = ganancia;
    }

    public String getIndentificacion() {
        return indentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public float getGanancia() {
        return ganancia;
    }

    public void setIndentificacion(String indentificacion) {
        this.indentificacion = indentificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGanancia(float ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public String toString() {
        return "Expositor{" + "indentificacion=" + indentificacion + ", nombre=" + nombre + ", email=" + email + ", ganancia=" + ganancia + '}';
    }
    
    
}
