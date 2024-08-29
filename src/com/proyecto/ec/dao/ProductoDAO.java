package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Producto;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO {

    public String agregarProducto(Connection con, Producto prod) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_PRODUCTO.INSERTAR_PRODUCTO_C(?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, prod.getNOMBRE_PRODUCTO());
            cst.setString(2, prod.getDESCRIPCION_PRODUCTO());
            cst.setDouble(3, prod.getCOSTO());
            cst.setInt(4, prod.getID_PROVEEDOR());
            cst.execute();
            mensaje = "PRODUCTO AGREGADO";
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

    public String modificarProducto(Connection con, Producto prod) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_PRODUCTO.ACTUALIZAR_PRODUCTO(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, prod.getID_PRODUCTO());
            cst.setString(2, prod.getNOMBRE_PRODUCTO());
            cst.setString(3, prod.getDESCRIPCION_PRODUCTO());
            cst.setDouble(4, prod.getCOSTO());
            cst.setInt(5, prod.getID_PROVEEDOR());
            cst.execute();
            mensaje = "PRODUCTO ACTUALIZADA";
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

    public String eliminarProducto(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_PRODUCTO.ELIMINAR_PRODUCTO(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.execute();
            mensaje = "PRODUCTO ELIMINADO";
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

    public void listarProductos(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{ ? = call PACKAGE_PRODUCTO.LISTAR_PRODUCTO }";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID_PRODUCTO", "NOMBRE_PRODUCTO", "DESCRIPCION_PRODUCTO", "COSTO", "ID_PROVEEDOR"});
            while (rs.next()) {
                int id = rs.getInt("ID_PRODUCTO");
                String nombre = rs.getString("NOMBRE_PRODUCTO");
                String descripcion = rs.getString("DESCRIPCION_PRODUCTO");
                int costo = rs.getInt("COSTO");
                int proveedor = rs.getInt("ID_PROVEEDOR");
                model.addRow(new Object[]{id, nombre, descripcion, costo, proveedor});
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
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
 public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement("SELECT MAX(ID_CITA)+1 as id FROM CITAS");
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
            
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return id;
    }
}
