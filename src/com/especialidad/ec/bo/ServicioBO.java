package com.especialidad.ec.bo;

import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Servicio;
import java.sql.Connection;
import java.sql.SQLException;
import com.proyecto.ec.dao.ServicioDAO;

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
}
