package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Servicio;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class ServicioDAO {

    public String agregarServicio(Connection con, Servicio ser) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_SERVICIO(?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, ser.getNOMBRE_SERVICIO());
            cst.setString(2, ser.getDESCRIPCION_SERVICIO());
            cst.setDouble(3, ser.getCOSTO());
            cst.execute();
            mensaje = "guardado";
        } catch (SQLException e) {
            mensaje = "No se ha guardado: " + e.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mensaje;
    }

    public String modificarServicio(Connection con, Servicio ser) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_SERVICIO(?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, ser.getID_SERVICIO());
            cst.setString(2, ser.getNOMBRE_SERVICIO());
            cst.setString(3, ser.getDESCRIPCION_SERVICIO());
            cst.setDouble(4, ser.getCOSTO());
            cst.execute();
            mensaje = "actualizado";
        } catch (SQLException e) {
            mensaje = "No se ha actualizado: " + e.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mensaje;
    }

    public String eliminarServicio(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ELIMINAR_SERVICIO(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.execute();
            mensaje = "eliminado";
        } catch (SQLException e) {
            mensaje = "No se ha eliminado: " + e.getMessage();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mensaje;
    }
}
