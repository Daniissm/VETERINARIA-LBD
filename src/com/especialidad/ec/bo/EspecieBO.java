package com.especialidad.ec.bo;

import com.proyecto.ec.dao.EspecialidadDAO;
import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Especialidad;
import com.proyecto.ec.entity.Especie;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;

/**
 *
 * @author fidelitas
 */
public class EspecieBO {
       private String mensaje = "";
       private EspecieDAO edao = new EspecieDAO();
       
   public String agregarEspecie(Especie spe){
       Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.agregarEspecie(conn, spe);
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
   
      public String modificarEspecie(Especie spe){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.modificarEspecialidad(conn, spe);
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
      
         public String eliminarEspecie(int id){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.eliminarEspecie(conn, id);
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
         
            public void listarEspecie(JTable tabla){
                Connection conn = Conexion.getConnection();
                edao.listarEspecialidad(conn, tabla);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
       
   } 
}