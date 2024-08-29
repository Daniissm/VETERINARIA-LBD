/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.dao;

import com.proyecto.ec.entity.FichaMedica;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FichaMedicaDAO {

    public String agregarFichaMedica(Connection con, FichaMedica fic) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_FICHA.INSERTAR_FICHA(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, fic.getID_MASCOTA());
            cst.setInt(2, fic.getID_VETERINARIO());
            cst.setString(3, fic.getMOTIVO());
            cst.setString(4, fic.getDIAGNOSTICO());
            cst.setString(5, fic.getTRATAMIENTO());
            cst.execute();
            mensaje = "FICHA MEDICA AGREGADA";
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

    public String modificarFichaMedica(Connection con, FichaMedica fic) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_FICHA.ACTUALIZAR_FICHA(?, ?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, fic.getID_FICHA_MEDICA());
            cst.setInt(2, fic.getID_MASCOTA());
            cst.setInt(3, fic.getID_VETERINARIO());
            cst.setString(4, fic.getMOTIVO());
            cst.setString(5, fic.getDIAGNOSTICO());
            cst.setString(6, fic.getTRATAMIENTO());
            cst.execute();
            mensaje = "FICHA MEDICA ACTUALIZADA";
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

    public String eliminarFichaMedica(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_FICHA.ELIMINAR_FICHA(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.execute();
            mensaje = "FICHA MEDICA ELIMINADA";
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

    public void listarFichasMedicas(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{ ? = call PACKAGE_FICHA.LISTAR_FICHA() }";; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID_FICHA_MEDICA", "ID_MASCOTA", "ID_VETERINARIO", "MOTIVO", "DIAGNOSTICO", "TRATAMIENTO"});
            while (rs.next()) {
                int idFichaMedica = rs.getInt("ID_FICHA_MEDICA");
                int idMascota = rs.getInt("ID_MASCOTA");
                int idVeterinario = rs.getInt("ID_VETERINARIO");
                String motivo = rs.getString("MOTIVO");
                String diagnostico = rs.getString("DIAGNOSTICO");
                String tratamiento = rs.getString("TRATAMIENTO");

                model.addRow(new Object[]{idFichaMedica, idMascota, idVeterinario, motivo, diagnostico, tratamiento});
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
