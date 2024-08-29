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

    public String agregarEspecialidad(Connection con, Especialidad emp) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_ESPECIALIDAD.INSERTAR_ESPECIALIDAD_C(?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, emp.getNOMBRE_ESPECIALIDAD());
            cst.setString(2, emp.getDESCRIPCION_ESPECIALIDAD());
            cst.execute();
            mensaje = "ESPECIALIDAD AGREGADA";
        } catch (SQLException e) {
            mensaje = "ERROR AL AGREGAR " + e.getMessage();
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
        String sql = "{call PACKAGE_ESPECIALIDAD.ACTUALIZAR_ESPECIALIDAD(?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, emp.getNOMBRE_ESPECIALIDAD());
            cst.setString(2, emp.getDESCRIPCION_ESPECIALIDAD());
            cst.execute();
            mensaje = "ESPECIALIDAD MODIFICADA";
        } catch (SQLException e) {
            mensaje = "ERROR AL MODIFICAR: " + e.getMessage();
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
        String sql = "{ ? = call PACKAGE_ESPECIALIDAD.XELIMINAR_ESPECIALIDAD(?) }"; // Asegúrate de que el número y tipo de parámetros son correctos

        try {
            // Preparar el CallableStatement
            cst = con.prepareCall(sql);
            
            // Registrar el parámetro de salida
            cst.registerOutParameter(1, java.sql.Types.VARCHAR);
            
            // Establecer el parámetro de entrada
            cst.setInt(2, idEspecialidad);

            // Ejecutar la llamada
            cst.execute();
            
            // Obtener el mensaje de la función
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



    public void listarEspecialidades(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{ ? = call PACKAGE_ESPECIALIDAD.LISTAR_ESPECIALIDADES }"; // Llamada a la función

        try {
            // Preparar la llamada a la función
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID ESPECIE", "NOMBRE", "DESCRIPCION"});
            while (rs.next()) {
                int id = rs.getInt("ID_ESPECIALIDAD"); // Cambiar nombre de columna
                String nombre = rs.getString("NOMBRE_ESPECIALIDAD"); // Cambiar nombre de columna
                String descripcion = rs.getString("DESCRIPCION_ESPECIALIDAD"); // Cambiar nombre de columna
                model.addRow(new Object[]{id, nombre, descripcion});
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
