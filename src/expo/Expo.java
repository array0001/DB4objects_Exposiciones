/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author USERE
 */
public class Expo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "exposicion.db4o");
        Expositor expositor1 = new Expositor("123456","Claudio Valencia","claudio@example.com",100000);
        try{
            Metodos.almacenarExpositor(baseDatos, expositor1);
        }finally{
            Metodos.cerrarConexion(baseDatos);
        }
    }
}
