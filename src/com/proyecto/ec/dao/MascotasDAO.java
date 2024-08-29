package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Mascotas;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MascotasDAO {

    public String agregarMascotas(Connection con, Mascotas mas) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_MASCOTA.INSERTAR_MASCOTA(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, mas.getNOMBRE_MASCOTA());
            cst.setString(2, mas.getRAZA());
            cst.setDouble(3, mas.getPESO());
            cst.setInt(4, mas.getESPECIE());
            cst.setInt(5, mas.getID_CLIENTE());
            cst.execute();
            mensaje = "MASCOTA AGREGADA";
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

    public String modificarMascotas(Connection con, Mascotas mas) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_MASCOTA.ACTUALIZAR_MASCOTA(?, ?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mas.getID_MASCOTA());
            cst.setString(2, mas.getNOMBRE_MASCOTA());
            cst.setString(3, mas.getRAZA());
            cst.setDouble(4, mas.getPESO());
            cst.setInt(5, mas.getESPECIE());
            cst.setInt(6, mas.getID_CLIENTE());
            cst.execute();
            mensaje = "MASCOTA ACTUALIZADA";
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

    public String eliminarMascotas(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{ ? = call PACKAGE_MASCOTA.XELIMINAR_MASCOTA(?) }"; // Asegúrate de que el número y tipo de parámetros son correctos

        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, java.sql.Types.VARCHAR);
            cst.setInt(2, id);
            cst.execute();
            mensaje = cst.getString(1);
        } catch (SQLException e) {
            mensaje = "ERROR: " + e.getMessage();
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
    String sql = "{? = call PACKAGE_MASCOTA.LISTAR_MASCOTA}";

    try {
        cst = con.prepareCall(sql);
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();
        rs = (ResultSet) cst.getObject(1);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID MASCOTA", "NOMBRE MASCOTA", "RAZA", "PESO", "ESPECIE", "ID CLIENTE"});
        while (rs.next()) {
            int idMascota = rs.getInt("ID_MASCOTA");
            String nombreMascota = rs.getString("NOMBRE_MASCOTA");
            String raza = rs.getString("RAZA");
            int peso = rs.getInt("PESO");
            int especie = rs.getInt("ESPECIE");
            int idCliente = rs.getInt("ID_CLIENTE");

            model.addRow(new Object[]{idMascota, nombreMascota, raza, peso, especie, idCliente});
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
