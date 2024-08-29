package com.especialidad.ec.bo;

import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Servicio;
import java.sql.Connection;
import java.sql.SQLException;
import com.proyecto.ec.dao.ServicioDAO;
import javax.swing.JTable;

public class ServicioBO {
    private String mensaje = "";
    private ServicioDAO edao = new ServicioDAO();

    public String agregarServicio(Servicio ser) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.agregarServicio(conn, ser);
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

    public String modificarServicio(Servicio ser) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.modificarServicio(conn, ser);
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

    public String eliminarServicio(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.eliminarServicio(conn, id);
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
    public void listarServicios(JTable tabla) {
        Connection conn = Conexion.getConnection();
        try {
            edao.listarServicios(conn, tabla);
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
