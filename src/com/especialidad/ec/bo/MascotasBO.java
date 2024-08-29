package com.especialidad.ec.bo;

import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Mascotas;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;
import com.proyecto.ec.dao.MascotasDAO;

public class MascotasBO {
    private String mensaje = "";
    private MascotasDAO edao = new MascotasDAO(); // Cambiado a MascotasDAO

    public String agregarMascotas(Mascotas mas) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.agregarMascotas(conn, mas);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarMascotas(Mascotas mas) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.modificarMascotas(conn, mas);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String eliminarMascotas(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.eliminarMascotas(conn, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

   public void listarMascotas(JTable tabla) {
        Connection conn = Conexion.getConnection();
        try {
            edao.listarMascotas(conn, tabla);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
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
