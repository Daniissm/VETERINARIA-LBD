/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Especialidad;
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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fidelitas
 */
public class EspecialidadDAO {
    private String mensaje = "";
    
    /*public String agregarEspecialidad (Connection con, Especialidad emp){
        PreparedStatement pst = null;
        String sql = "INSERT INTO ESPECIALIDAD (ID_ESPECIALIDAD, NOMBRE_ESPECIALIDAD, DESCRIPCION_ESPECIALIDAD" + "VALUES(ESPECIALIDAD_SEQ.NEXTVAL, ?, ?)";        return mensaje;
        try {
            pst = con.PreparedStatement(sql);
            pst.setString(1, emp.getNOMBRE_ESPECIALIDAD());
            pst.setString(2, emp.getDESCRIPCION_ESPECIALIDAD());
            mensaje = "guardado";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "No se ha guardado" + e.getMessage();
        }
    }*/
     public String agregarEspecialidad(Connection con, Especialidad emp) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ESPECIALIDAD_PACKAGE.INSERTAR_ESPECIALIDAD(?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, emp.getNOMBRE_ESPECIALIDAD());
            cst.setString(2, emp.getDESCRIPCION_ESPECIALIDAD());
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
     public String modificarEspecialidad(Connection con, Especialidad emp) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_ESPECIALIDAD(?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);         
            cst.setInt(1, emp.getID_ESPECIALIDAD());
            cst.setString(2, emp.getNOMBRE_ESPECIALIDAD());
            cst.setString(3, emp.getDESCRIPCION_ESPECIALIDAD());           
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
      public String eliminarEspecialidad(Connection con, int idEspecialidad) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ESPECIALIDAD_PACKAGE.ELIMINAR_ESPECIALIDAD(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, idEspecialidad);
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
    

public void listarEspecialidad(Connection con, JTable tabla) {
    CallableStatement cst = null;
    ResultSet rs = null;
    String sql = "{call ESPECIALIDAD_PACKAGE.LISTAR_ESPECIALIDAD(?)}";
    try {
        cst = con.prepareCall(sql);
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();
        
        rs = (ResultSet) cst.getObject(1);
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID_ESPECIALIDAD");
        model.addColumn("NOMBRE_ESPECIALIDAD");
        model.addColumn("DESCRIPCION_ESPECIALIDAD");
        
        while (rs.next()) {
            int id = rs.getInt("ID_ESPECIALIDAD");
            String nombre = rs.getString("NOMBRE_ESPECIALIDAD");
            String descripcion = rs.getString("DESCRIPCION_ESPECIALIDAD");
            model.addRow(new Object[]{id, nombre, descripcion});
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
