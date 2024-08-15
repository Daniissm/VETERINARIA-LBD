package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Producto;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO {

    public String agregarProducto(Connection con, Producto prod) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_PRODUCTO(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, prod.getNOMBRE_PRODUCTO());
            cst.setString(2, prod.getDESCRIPCION_PRODUCTO());
            cst.setDouble(3, prod.getCOSTO());
            cst.setInt(4, prod.getID_PROVEEDOR());
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

    public String modificarProducto(Connection con, Producto prod) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_PRODUCTO(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, prod.getID_PRODUCTO());
            cst.setString(2, prod.getNOMBRE_PRODUCTO());
            cst.setString(3, prod.getDESCRIPCION_PRODUCTO());
            cst.setDouble(4, prod.getCOSTO());
            cst.setInt(5, prod.getID_PROVEEDOR());
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

    public String eliminarProducto(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ELIMINAR_PRODUCTO(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
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
