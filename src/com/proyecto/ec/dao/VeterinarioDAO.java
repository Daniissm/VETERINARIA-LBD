package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Veterinario;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Types;

public class VeterinarioDAO {

    public String agregarVeterinario(Connection con, Veterinario vet) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_VETERINARIO(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, vet.getNOMBRE_VETERINARIO());
            cst.setString(2, vet.getAPELLIDO_PATERNO());
            cst.setInt(3, vet.getCODIGO_VETERINARIO());
            cst.setInt(4, vet.getESPECIALDIAD());
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

    public String modificarVeterinario(Connection con, Veterinario vet) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_VETERINARIO(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, vet.getID_VETERINARIO());
            cst.setString(2, vet.getNOMBRE_VETERINARIO());
            cst.setString(3, vet.getAPELLIDO_PATERNO());
            cst.setInt(4, vet.getCODIGO_VETERINARIO());
            cst.setInt(5, vet.getESPECIALDIAD());
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

    public String eliminarVeterinario(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ELIMINAR_VETERINARIO(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
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
