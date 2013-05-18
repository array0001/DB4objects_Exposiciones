/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expo;

/**
 *
 * @author USERE
 */
public class Conferencia {
    private String titulo;
    private float duracion;
    private Expositor expositor;

    public Conferencia(String titulo, float duracion, Expositor expositor) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.expositor = expositor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    @Override
    public String toString() {
        return "Conferencia{" + "titulo=" + titulo + ", duracion=" + duracion + ", expositor=" + expositor + '}';
    }
    
    
    
}
