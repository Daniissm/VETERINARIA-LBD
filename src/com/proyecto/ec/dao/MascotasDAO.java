package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Mascotas;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MascotasDAO {

    public String agregarMascotas(Connection con, Mascotas mas) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_MASCOTA(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, mas.getNOMBRE_MASCOTA());
            cst.setString(2, mas.getRAZA());
            cst.setDouble(3, mas.getPESO());
            cst.setInt(4, mas.getESPECIE());
            cst.setInt(5, mas.getID_CLIENTE());
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

    public String modificarMascotas(Connection con, Mascotas mas) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_MASCOTA(?, ?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mas.getID_MASCOTA());
            cst.setString(2, mas.getNOMBRE_MASCOTA());
            cst.setString(3, mas.getRAZA());
            cst.setDouble(4, mas.getPESO());
            cst.setInt(5, mas.getESPECIE());
            cst.setInt(6, mas.getID_CLIENTE());
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

    public String eliminarMascotas(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ELIMINAR_MASCOTA(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
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
    public void listarMascotas(Connection con, JTable tabla) {
    CallableStatement cst = null;
    ResultSet rs = null;
    String sql = "{call LISTAR_MASCOTAS(?)}";  
    try {
        cst = con.prepareCall(sql);
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();
        rs = (ResultSet) cst.getObject(1);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_MASCOTA");
        model.addColumn("NOMBRE_MASCOTA");
        model.addColumn("RAZA");
        model.addColumn("PESO");
        model.addColumn("NOMBRE_ESPECIE");
        model.addColumn("NOMBRE_CLIENTE");
        while (rs.next()) {
            int id = rs.getInt("ID_MASCOTA");
            String nombre = rs.getString("NOMBRE_MASCOTA");
            String raza = rs.getString("RAZA");
            double peso = rs.getDouble("PESO");
            String especie = rs.getString("NOMBRE_ESPECIE");
            String cliente = rs.getString("NOMBRE_CLIENTE");

            model.addRow(new Object[]{id, nombre, raza, peso, especie, cliente});
        }

        tabla.setModel(model);

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar recursos
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
