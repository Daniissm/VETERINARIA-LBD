package com.proyecto.ec.dao;

import java.sql.Types;
import com.proyecto.ec.entity.Servicio;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import com.proyecto.ec.entity.Producto;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServicioDAO {

    public String agregarServicio(Connection con, Servicio ser) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_SERVICIO.INSERTAR_SERVICIO_C(?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, ser.getNOMBRE_SERVICIO());
            cst.setString(2, ser.getDESCRIPCION_SERVICIO());
            cst.setDouble(3, ser.getCOSTO());
            cst.execute();
            mensaje = "SERIVICO AGREGADO";
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

    public String modificarServicio(Connection con, Servicio ser) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_SERVICIO.ACTUALIZAR_SERVICIO(?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, ser.getID_SERVICIO());
            cst.setString(2, ser.getNOMBRE_SERVICIO());
            cst.setString(3, ser.getDESCRIPCION_SERVICIO());
            cst.setDouble(4, ser.getCOSTO());
            cst.execute();
            mensaje = "SERVICIO ACTUALIZADO";
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

    public String eliminarServicio(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_SERVICIO.ELIMINAR_SERVICIO(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.execute();
            mensaje = "SERVICIO ELIMINADO";
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

    public void listarServicios(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{ ? = call PACKAGE_SERVICIO.LISTAR_SERVICIO }"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID_SERVICIO", "NOMBRE_SERVICIO", "DESCRIPCION_SERVICIO", "COSTO"});
            while (rs.next()) {
                int id = rs.getInt("ID_SERVICIO");
                String nombre = rs.getString("NOMBRE_SERVICIO");
                String descripcion = rs.getString("DESCRIPCION_SERVICIO");
                int costo = rs.getInt("COSTO");
                model.addRow(new Object[]{id, nombre, descripcion, costo});
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
