package com.especialidad.ec.bo;

import com.proyecto.ec.dao.ClientesDAO;
import com.proyecto.ec.dao.EspecialidadDAO;
import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Clientes;
import com.proyecto.ec.entity.Especialidad;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;

/**
 *
 * @author fidelitas
 */
public class ClientesBO {
       private String mensaje = "";
       private ClientesDAO edao = new ClientesDAO();
       
   public String agregarClientes(Clientes cli){
       Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.agregarClientes(conn, cli);
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
   
      public String modificarClientes(Clientes cli){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.modificarClientes(conn, cli);
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
      
         public String eliminarClientes(int id){
Connection conn = Conexion.getConnection();
       try {
           mensaje = edao.eliminarClientes(conn, id);
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
         
            public void listarClientes(JTable tabla){
                Connection conn = Conexion.getConnection();
                edao.listarClientes(conn, tabla);
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