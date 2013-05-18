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
        
    }
}
