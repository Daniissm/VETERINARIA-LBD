package com.especialidad.ec.bo;

import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.FichaMedica;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;

/**
 *
 * @author fidelitas
 */
public class FichaMedicaBO {
       private String mensaje = "";
       private FichaMedicaBO edao = new FichaMedicaBO();
       
   public String agregarFichaMedica(FichaMedica fic){
       Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.agregarFichaMedica(conn, fic);
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
   
      public String modificarFichaMedica(FichaMedica fic){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.modificarFichaMedica(conn, fic);
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
      
         public String eliminarFichaMedica(int id){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.eliminarFichaMedica(conn, id);
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
         
            public void listarFichaMedica(JTable tabla){
                Connection conn = Conexion.getConnection();
                edao.listarFichaMedica(conn, tabla);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
       
   } 