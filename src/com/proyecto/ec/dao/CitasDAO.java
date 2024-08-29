/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.dao;

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
import com.proyecto.ec.entity.Citas;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fidelitas
 */
public class CitasDAO {

    public String agregarCita(Connection con, Citas cita) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_CITAS.INSERTAR_CITAS(?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setDate(1, Date.valueOf(cita.getFECHA_CITA()));
            cst.setInt(2, cita.getID_CLIENTE());
            cst.setInt(3, cita.getID_VETERINARIO());
            cst.setInt(4, cita.getID_MASCOTA());
            cst.execute();
            mensaje = "CITA AGREGADA EXITOSAMENTE";
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

    public String modificarCita(Connection con, Citas cita) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_CITAS.ACTUALIZAR_CITAS(?, ?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cita.getID_CITA());
            cst.setDate(2, Date.valueOf(cita.getFECHA_CITA()));
            cst.setInt(3, cita.getID_CLIENTE());
            cst.setInt(4, cita.getID_VETERINARIO());
            cst.setInt(5, cita.getID_MASCOTA());
            cst.execute();
            mensaje = "CITA ACTUALIZADA";
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

    public String eliminarCita(Connection con, int idCita) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_CITAS.ELIMINAR_CITA(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, idCita);
            cst.execute();
            mensaje = "CITA ELIMINADA";
        } catch (SQLException e) {
            mensaje = "ERROR AL ELIMINAR CITA: " + e.getMessage();
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

   public void listarCitas(Connection con, JTable tabla) {
    CallableStatement cst = null;
    ResultSet rs = null;
    String sql = "{? = call PACKAGE_CITAS.LISTAR_CITA}"; 
    try {
        cst = con.prepareCall(sql);
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();
        rs = (ResultSet) cst.getObject(1);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID CITA", "FECHA", "ID CLIENTE", "ID VETERINARIO", "ID MASCOTA"});
        while (rs.next()) {
            int idCita = rs.getInt("ID_CITA");
            LocalDate fechaCita = rs.getDate("FECHA_CITA").toLocalDate(); // Convertir Date a LocalDate si es necesario
            int idCliente = rs.getInt("ID_CLIENTE");
            int idVeterinario = rs.getInt("ID_VETERINARIO");
            int idMascota = rs.getInt("ID_MASCOTA");

            model.addRow(new Object[]{idCita, fechaCita, idCliente, idVeterinario, idMascota});
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
