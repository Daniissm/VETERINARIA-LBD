package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Veterinario;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class VeterinarioDAO {

    public String agregarVeterinario(Connection con, Veterinario vet) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_VETERINARIO.INSERTAR_VETERINARIO(?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, vet.getNOMBRE_VETERINARIO());
            cst.setString(2, vet.getAPELLIDO_PATERNO());
            cst.setInt(3, vet.getCODIGO_VETERINARIO());
            cst.setInt(4, vet.getESPECIALDIAD());
            cst.execute();
            mensaje = "VETERINARIO AGREGADO";
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

    public String modificarVeterinario(Connection con, Veterinario vet) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_VETERINARIO.ACTUALIZAR_VETERINARIO(?, ?, ?, ?, ?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, vet.getID_VETERINARIO());
            cst.setString(2, vet.getNOMBRE_VETERINARIO());
            cst.setString(3, vet.getAPELLIDO_PATERNO());
            cst.setInt(4, vet.getCODIGO_VETERINARIO());
            cst.setInt(5, vet.getESPECIALDIAD());
            cst.execute();
            mensaje = "VETERINARIO ACTUALIZADO";
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

    public String eliminarVeterinario(Connection con, int id) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call PACKAGE_VETERINARIO.ELIMINAR_VETERINARIO(?)}"; // Asegúrate de que este procedimiento almacenado existe y tiene la firma correcta.
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.execute();
            mensaje = "VETERINARIO ELIMINADO";
        } catch (SQLException e) {
            mensaje = "ERROR AL ELIMINAR " + e.getMessage();
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
    
    public void listarVeterinarios(Connection con, JTable tabla) {
    CallableStatement cst = null;
    ResultSet rs = null;
    String sql = "{ ? = call PACKAGE_VETERINARIO.LISTAR_VETERINARIOS }"; // Nota: Aquí se usa un ? para el retorno en el SQL

    try {
        cst = con.prepareCall(sql);
                cst.registerOutParameter(1, Types.REF_CURSOR);
                cst.execute();
                rs = (ResultSet) cst.getObject(1);
                DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID_VETERINARIO", "NOMBRE_VETERINARIO", "APELLIDO_PATERNO", "CODIGO_VETERINARIO", "ESPECIALIDAD"});
                while (rs.next()) {
            int id = rs.getInt("ID_VETERINARIO");
            String nombre = rs.getString("NOMBRE_VETERINARIO");
            String apellido = rs.getString("APELLIDO_PATERNO");
            int codigo = rs.getInt("CODIGO_VETERINARIO");
            int especialidad = rs.getInt("ESPECIALIDAD");
            model.addRow(new Object[]{id, nombre, apellido, codigo, especialidad});
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
