package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Especialidad;
import com.proyecto.ec.entity.Especie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import javax.swing.JTable;


public class EspecieDAO {
    private String mensaje = "";
    
    public String agregarEspecie(Connection con, Especie esp) {
    CallableStatement cst = null;
    String mensaje = "";
    String sql = "{call INSERTAR_ESPECIE(?, ?)}"; 
    try {
        cst = con.prepareCall(sql);
        cst.setString(1, esp.getFAMILIA());
        cst.setString(2, esp.getESPECIE());
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
public String modificarEspecie(Connection con, Especie esp) {
    CallableStatement cst = null;
    String mensaje = "";
    String sql = "{call ACTUALIZAR_ESPECIE(?, ?, ?)}"; 
    try {
        cst = con.prepareCall(sql);
        cst.setInt(1, esp.getID_ESPECIE());
        cst.setString(2, esp.getFAMILIA());
        cst.setString(3, esp.getESPECIE());
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
public String eliminarEspecie(Connection con, int idEspecie) {
    CallableStatement cst = null;
    String mensaje = "";
    String sql = "{call ELIMINAR_ESPECIE(?)}"; 
    try {
        cst = con.prepareCall(sql);
        cst.setInt(1, idEspecie);
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
     public void listarEspecie(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{call LISTAR_ESPECIE(?)}";
        try {
            cst = con.prepareCall(sql);
                        cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            while (rs.next()) {
                int id = rs.getInt("ID_ESPECIE");
                String familia = rs.getString("FAMILIA");
                String especie = rs.getString("ESPECIE");
                System.out.println("ID: " + id + ", Familia: " + familia + ", Especie: " + especie);
            }
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
}