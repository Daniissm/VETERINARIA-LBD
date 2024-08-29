
package com.especialidad.ec.bo;

import com.proyecto.ec.dao.CitasDAO;
import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Citas;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author fidelitas
 */
public class CitasBO {
       private String mensaje = "";
       private CitasDAO edao = new CitasDAO();
       
   public String agregarCita (Citas cit){
       Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.agregarCita(conn, cit);
       } catch (Exception e) {
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try {
               if (conn != null){
               conn.close();
               }
           } catch (Exception e) {
               mensaje = mensaje + "" + e.getMessage();
           }
       }
       return mensaje;
       
   }
   
      public String modificarCita(Citas cit){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.modificarCita(conn, cit);
       } catch (Exception e) {
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try {
               if (conn != null){
               conn.close();
               }
           } catch (Exception e) {
               mensaje = mensaje + "" + e.getMessage();
           }
       }
       return mensaje;       
   }
      
         public String eliminarCita(int id){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.eliminarCita(conn, id);
       } catch (Exception e) {
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try {
               if (conn != null){
               conn.close();
               }
           } catch (Exception e) {
               mensaje = mensaje + "" + e.getMessage();
           }
       }
       return mensaje;       
   }
         
            public void listarCitas(JTable tabla){
                Connection conn = Conexion.getConnection();
                edao.listarCitas(conn, tabla);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
       
   } 
            public int getMaxID (){
         Connection conn = Conexion.getConnection();
                int id = edao.getMaxID(conn);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
                return id;
       }
}
