/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expo;

import com.db4o.ObjectContainer;

/**
 *
 * @author USERE
 */
public class Metodos {
    
    public static void almacenarExpositor(ObjectContainer bd, Expositor expositor){
        try{
            bd.store(expositor);
            System.out.println("Se guardo el expositor.");
        }catch(Exception e){
            System.out.println("Error guardando el expositor.");
        }
    }
    
    public static void cerrarConexion(ObjectContainer baseDatos){
        try{
            baseDatos.close();
        }catch(Exception e){
            System.out.println("Error en el cierre de la BD.");
        }
        
    }
}
