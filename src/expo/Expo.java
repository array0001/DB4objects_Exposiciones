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
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "exposition.db4o");
        Expositor expositor1 = new Expositor("1234568","Claudio Valencia","claudio@example.com",100000);
        Expositor expositor2 = new Expositor("1234567","Carlos Zapata","carlos@example.com",200000);
        Expositor expositor3 = new Expositor("1234560","Camilo Rodriguez","camilo@example.com",300000);
        Expositor expositor4 = new Expositor("1234569","Luis Valencia","luis@example.com",400000);
        Expositor expositor5 = new Expositor("1234510","Manuel Monsalve","manuel@example.com",500000);
        Expositor expositor6 = new Expositor("1234511","Sofia Valencia","sofi@example.com",600000);
        Expositor expositor7 = new Expositor("1234519","Jonathan Tamayo","jonas@example.com",600000);
       
        
        try{
          /* 
           Metodos.almacenarExpositor(baseDatos, expositor1);
           Metodos.almacenarExpositor(baseDatos, expositor2);
           Metodos.almacenarExpositor(baseDatos, expositor3);
           Metodos.almacenarExpositor(baseDatos, expositor4);
           Metodos.almacenarExpositor(baseDatos, expositor5);
           Metodos.almacenarExpositor(baseDatos, expositor6);
           Metodos.almacenarExpositor(baseDatos, expositor7);
          */
        
         // Busquedas de Expositores Mendiante el metodo de Consulta Query-BY-Example
          /* System.out.println("Todos los Ponentes");
           Metodos.ConsultarQBEExpositorPorNombre(baseDatos, null);
           System.out.println("-----------------------------");
           System.out.println("Expositor de nombre Carlos Zapata");
           Metodos.ConsultarQBEExpositorPorNombre(baseDatos, "Carlos Zapata");
           System.out.println("-----------------------------");
           System.out.println("Expositor con ganancia de 200000");
           Metodos.ConsultarQBEExpositorPorGanancia(baseDatos, 200000);
           System.out.println("-----------------------------");
           System.out.println("Expositor con Identificacion 1234568");
           Metodos.consultarQBEExpositorPorIdentificacion(baseDatos, "1234568");
          */ 
         // Busqueda de Expositores Mediante Consultas Nativas.
           /* System.out.println("Expositor con Identificacion 1234519");
           Metodos.ConsultarNativaPonentesIdentificacion(baseDatos, "1234519");
           System.out.println("----------------------------------");
           System.out.println(" Expositor con Ganancias de 600000 ");
           Metodos.ConsultarNativaExpositorPorGanancia(baseDatos, 600000);
           System.out.println("----------------------------------");
           System.out.println("Expositores con Ganancias Mayores a 300000");
           Metodos.ConsultarNativaExpositoresPorGananciaMayor(baseDatos, 300000);
           System.out.println("----------------------------------");
           */
         // Busqueda De Expositores Mediante Consultas SODA.
           System.out.println("Expositor con Nombre Luis Valencia");
           Metodos.ConsultaSODAExpositoresPorNombre(baseDatos, "Luis Valencia");
           System.out.println("----------------------------------");
           System.out.println("Todos Los Expositores");
           Metodos.ConsultaSODAExpositores(baseDatos);
           System.out.println("----------------------------------");
           System.out.println("Expositores con Gannacias entre 200000 y 500000");
           Metodos.ConsultaSodaExpositoresPorGanancia(baseDatos, 200000,500000);
           System.out.println("----------------------------------");
           System.out.println("Expositores Ordenados por Ganancia");
           Metodos.ConsultaSODAExpositoresOrdenadosPorGanancia(baseDatos);
           System.out.println("----------------------------------");
           
           
           // Esto fueron los tipicos ejemplos de como usar Las Consultas o tipos de Consultas en DB4o.
           
           
           
           
           
            
           
           
           
           
        }finally{
            Metodos.cerrarConexion(baseDatos);
        }
    }
}
