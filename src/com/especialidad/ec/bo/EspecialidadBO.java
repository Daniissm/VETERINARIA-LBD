/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.especialidad.ec.bo;

import com.proyecto.ec.dao.EspecialidadDAO;
import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Especialidad;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;

/**
 *
 * @author fidelitas
 */
public class EspecialidadBO {
       private String mensaje = "";
       private EspecialidadDAO edao = new EspecialidadDAO();
       
   public String agregarEspecialidad(Especialidad emp){
       Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.agregarEspecialidad(conn, emp);
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
   
      public String modificarEspecialidad(Especialidad emp){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.modificarEspecialidad(conn, emp);
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
      
         public String eliminarEspecialidad(int id){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.eliminarEspecialidad(conn, id);
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
         
            public void listarEspecialidad(JTable tabla){
                Connection conn = Conexion.getConnection();
                edao.listarEspecialidades(conn, tabla);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
       
   } 
    /*public int getMaxID( ){
       Connection conn = Conexion.getConnection();
                int id = edao.getMaxID(conn);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
           return id;
    }*/
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
