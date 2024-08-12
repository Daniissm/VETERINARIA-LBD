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

/**
 *
 * @author fidelitas
 */
public class CitasDAO {
    public String agregarCita(Connection con, Citas cita) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_CITAS(?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setDate(1, Date.valueOf(cita.getFECHA_CITA()));
            cst.setInt(2, cita.getID_CLIENTE());
            cst.setInt(3, cita.getID_VETERINARIO());
            cst.setInt(4, cita.getID_MASCOTA());
            cst.execute();
            mensaje = "Cita guardada";
        } catch (SQLException e) {
            mensaje = "No se ha guardado la cita: " + e.getMessage();
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
        String sql = "{call ACTUALIZAR_CITA(?, ?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cita.getID_CITA());
            cst.setDate(2, Date.valueOf(cita.getFECHA_CITA()));
            cst.setInt(3, cita.getID_CLIENTE());
            cst.setInt(4, cita.getID_VETERINARIO());
            cst.setInt(5, cita.getID_MASCOTA());
            cst.execute();
            mensaje = "Cita actualizada";
        } catch (SQLException e) {
            mensaje = "No se ha actualizado la cita: " + e.getMessage();
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
        String sql = "{call ELIMINAR_CITA(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, idCita);
            cst.execute();
            mensaje = "Cita eliminada";
        } catch (SQLException e) {
            mensaje = "No se ha eliminado la cita: " + e.getMessage();
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
        String sql = "{call LISTAR_CITAS(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            while (rs.next()) {
                int idCita = rs.getInt("ID_CITA");
                LocalDate fechaCita = rs.getDate("FECHA_CITA").toLocalDate();
                int idCliente = rs.getInt("ID_CLIENTE");
                int idVeterinario = rs.getInt("ID_VETERINARIO");
                int idMascota = rs.getInt("ID_MASCOTA");
                System.out.println("ID Cita: " + idCita + ", Fecha: " + fechaCita + ", Cliente ID: " + idCliente + ", Veterinario ID: " + idVeterinario + ", Mascota ID: " + idMascota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
