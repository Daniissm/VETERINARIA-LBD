/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.dao;

import com.proyecto.ec.entity.FichaMedica;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FichaMedicaDAO {

    public String agregarFichaMedica(Connection con, FichaMedica fic) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_FICHA_MEDICA(?, ?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, fic.getID_MASCOTA());
            cst.setInt(2, fic.getID_VETERINARIO());
            cst.setString(3, fic.getMOTIVO());
            cst.setString(4, fic.getDIAGNOSTICO());
            cst.setString(5, fic.getTRATAMIENTO());
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

    public String modificarFichaMedica(Connection con, FichaMedica fic) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_FICHA_MEDICA(?, ?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, fic.getID_FICHA_MEDICA());
            cst.setInt(2, fic.getID_MASCOTA());
            cst.setInt(3, fic.getID_VETERINARIO());
            cst.setString(4, fic.getMOTIVO());
            cst.setString(5, fic.getDIAGNOSTICO());
            cst.setString(6, fic.getTRATAMIENTO());
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

    public String eliminarFichaMedica(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ELIMINAR_FICHA_MEDICA(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
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

    
}
