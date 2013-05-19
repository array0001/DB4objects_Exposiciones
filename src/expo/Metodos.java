/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.List;
import com.db4o.query.Constraint;
import com.db4o.query.Query;



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
       public static void almacenarConferencia(ObjectContainer baseDatos, Conferencia con) {
        try {
            baseDatos.store(con);
            System.out.println("Se guardo la conferencia");
        } catch (Exception e) {
            System.out.println("Error guardando la conferencia");
        }
    }
    
    public static void actualizaGananciaExpositor(ObjectContainer bd,String nExpositor, float nuevaGanancia){
       try{
        Query query = bd.query();
        query.constrain(Expositor.class);
        query.descend("nombre").constrain(nExpositor);
        ObjectSet res = query.execute();
        Expositor ex = (Expositor)res.get(0);
        ex.setGanancia(nuevaGanancia);
        bd.store(ex);
       }catch(Exception e){
           System.out.println("No se encontro el Expositor a actualizar");
       }
        
    }
    
    public static void actualizaTituloConferencia(ObjectContainer bd,String tituloConferenciaOld,String tituloNew){
        Query query = bd.query();
        query.constrain(Conferencia.class);
        query.descend("titulo").constrain(tituloConferenciaOld);
        ObjectSet res =query.execute();
        Conferencia c = (Conferencia) res.get(0);
        c.setTitulo(tituloNew);
        bd.store(c);
    }
    
     public static void consultaSODAConferenciaTitulo(ObjectContainer baseDatos, String titulo) {
        Query query = baseDatos.query();
        query.constrain(Conferencia.class);
        query.descend("titulo").constrain(titulo);
        ObjectSet resultado = query.execute();
        imprimirResultadoConsulta(resultado);
     }
     
     public static void consultaSODAConferencias(ObjectContainer bd){
         Query query = bd.query();
         query.constrain(Conferencia.class);
         ObjectSet res = query.execute();
         imprimirResultadoConsulta(res);
     }
    
    public static void cerrarConexion(ObjectContainer baseDatos){
        try{
            baseDatos.close();
        }catch(Exception e){
            System.out.println("Error en el cierre de la BD.");
        }
    }
     
    public static void imprimirResultadoConsulta(ObjectSet resultado){
        System.out.println("Informacion: " + resultado.size() + " Objetos");
        while(resultado.hasNext()){
            System.out.println(resultado.next());
        }
    }
    
    // Tipos de Consultas.
    
    public static void consultarQBEExpositorPorIdentificacion(ObjectContainer baseDeDatos, String identificacion){
        Expositor nuevoExpositor = new Expositor(identificacion, null,null,0);
        ObjectSet resultado = baseDeDatos.queryByExample(nuevoExpositor);
        imprimirResultadoConsulta(resultado);
    }
    
    public static void ConsultarQBEExpositorPorNombre(ObjectContainer baseDeDatos, String nombre){
        Expositor nuevoExpositor = new Expositor(null,nombre,null,0);
        ObjectSet resultado = baseDeDatos.queryByExample(nuevoExpositor);
        imprimirResultadoConsulta(resultado);
    }
    
    public static void ConsultarQBEExpositorPorGanancia(ObjectContainer baseDeDatos, float ganancia){
        Expositor nuevoExpositor = new Expositor(null,null,null,ganancia);
        ObjectSet resultado = baseDeDatos.queryByExample(nuevoExpositor);
        imprimirResultadoConsulta(resultado);
    }
    
   public static void ConsultarNativaPonentesIdentificacion(ObjectContainer baseDeDatos, final String identificacion){
       List resultado = baseDeDatos.query(new com.db4o.query.Predicate(){
           public boolean match(Expositor nuevoExpositor){
               return nuevoExpositor.getIndentificacion().equalsIgnoreCase(identificacion);
           }
            @Override
           public boolean match(Object et){
              throw new UnsupportedOperationException("Not Supported yet.");
           }
       });
       imprimirResultadoConsulta((ObjectSet) resultado);
   }
   
   public static void ConsultarNativaExpositorPorGanancia(ObjectContainer baseDeDatos, final float ganancia){
       List resultado = baseDeDatos.query(new com.db4o.query.Predicate(){
           public boolean match(Expositor nuevoExpositor){
               return nuevoExpositor.getGanancia()== ganancia;
           }
            @Override
           public boolean match(Object et){
              throw new UnsupportedOperationException("Not Supported yet.");
           }
           
       });
       imprimirResultadoConsulta((ObjectSet) resultado);
       
   }
   public static void ConsultarNativaExpositoresPorGananciaMayor(ObjectContainer baseDeDatos, final float gananciaBase){
       List resultado = baseDeDatos.query(new com.db4o.query.Predicate(){
           public boolean match(Expositor nuevoExpositor){
               return nuevoExpositor.getGanancia()>= gananciaBase;
           }
            @Override
           public boolean match(Object et){
              throw new UnsupportedOperationException("Not Supported yet.");
           }
           
       });
       imprimirResultadoConsulta((ObjectSet) resultado);
       
   }
   
   public static void ConsultaSODAExpositores(ObjectContainer baseDeDatos){
       Query nuevoQuery = baseDeDatos.query();
       nuevoQuery.constrain(Expositor.class);
       ObjectSet resultado = nuevoQuery.execute();
       imprimirResultadoConsulta(resultado);
   }
   
   public static void ConsultaSODAExpositoresPorNombre(ObjectContainer baseDeDatos, String nombre){
       Query nuevoQuery = baseDeDatos.query();
       nuevoQuery.constrain(Expositor.class);
       Constraint nuevoConstraint = nuevoQuery.descend("nombre").constrain(nombre);
       ObjectSet resultado = nuevoQuery.execute();
       imprimirResultadoConsulta(resultado);
   }
   
   public static void ConsultaSodaExpositoresPorGanancia(ObjectContainer baseDeDatos, float gananciaInferior, float gananciaSuperior){
       Query nuevoQuery = baseDeDatos.query();
       nuevoQuery.constrain(Expositor.class);
       Constraint nuevoConstraint = nuevoQuery.descend("ganancia").constrain(gananciaSuperior).smaller();
       nuevoQuery.descend("ganancia").constrain(gananciaInferior).greater().and(nuevoConstraint);
       ObjectSet resultado = nuevoQuery.execute();
       imprimirResultadoConsulta(resultado);
   }
   public static void ConsultaSODAExpositoresOrdenadosPorGanancia(ObjectContainer baseDeDatos){
       Query nuevoQuery = baseDeDatos.query();
       nuevoQuery.constrain(Expositor.class);
       nuevoQuery.descend("ganancia").orderDescending();
       ObjectSet resultado = nuevoQuery.execute();
       imprimirResultadoConsulta(resultado);
   }
   
   // Ahora a Realizar las Pruebas.
   

    
        
 }

