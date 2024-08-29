/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Proveedores;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fidelitas
 */
public class ProveedoresDAO {

    public String agregarProveedor(Connection con, Proveedores proveedor) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_PROVEEDOR.INSERTAR_PROVEEDOR_C(?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, proveedor.getNOMBRE_PROVEEDOR());
            cst.setString(2, proveedor.getDIRECCION_PROVEEDOR());
            cst.execute();
            mensaje = "PROVEEDOR AGREGADO";
        } catch (SQLException e) {
            mensaje = "ERROR AL AGREGAR: " + e.getMessage();
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

    public String modificarProveedor(Connection con, Proveedores proveedor) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_PROVEEDOR.ACTUALIZAR_PROVEEDOR(?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, proveedor.getID_PROVEEDOR());
            cst.setString(2, proveedor.getNOMBRE_PROVEEDOR());
            cst.setString(3, proveedor.getDIRECCION_PROVEEDOR());
            cst.execute();
            mensaje = "PROVEEDOR ACTUALIZAD0";
        } catch (SQLException e) {
            mensaje = "ERROR AL ACTUALIZAR: " + e.getMessage();
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

    public String eliminarProveedor(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{ ? = call PACKAGE_PROVEEDOR.XELIMINAR_PROVEEDOR(?) }"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.setInt(2, id);
            cst.execute();
            mensaje = cst.getString(1);
        } catch (SQLException e) {
            mensaje = "ERROR AL ELIMINAR: " + e.getMessage();
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

    public void listarProveedores(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{ ? = call PACKAGE_PROVEEDOR.LISTAR_PROVEEDOR }"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID_PROVEEDOR", "NOMBRE_PROVEEDOR", "DIRECCION_PROVEEDOR"});
            while (rs.next()) {
                int id = rs.getInt("ID_PROVEEDOR");
                String nombre = rs.getString("NOMBRE_PROVEEDOR");
                String direccion = rs.getString("DIRECCION_PROVEEDOR");
                model.addRow(new Object[]{id, nombre, direccion});
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
