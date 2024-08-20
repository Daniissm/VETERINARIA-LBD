/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.dao;

import com.proyecto.ec.entity.Clientes;
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
public class ClientesDAO {

    public String agregarClientes(Connection con, Clientes cliente) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call INSERTAR_CLIENTE(?, ?, ?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cliente.getIDENTIFICACION());
            cst.setString(2, cliente.getNOMBRE_CLIENTE());
            cst.setString(3, cliente.getPRIMER_APELLIDO());
            cst.setString(4, cliente.getSEGUNDO_APELLIDO());
            cst.setString(5, cliente.getDIRECCION_CLIENTE());
            cst.setInt(6, cliente.getCELULAR());
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

    public String modificarClientes(Connection con, Clientes cliente) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ACTUALIZAR_CLIENTE(?, ?, ?, ?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cliente.getID_CLIENTE());
            cst.setInt(2, cliente.getIDENTIFICACION());
            cst.setString(3, cliente.getNOMBRE_CLIENTE());
            cst.setString(4, cliente.getPRIMER_APELLIDO());
            cst.setString(5, cliente.getSEGUNDO_APELLIDO());
            cst.setString(6, cliente.getDIRECCION_CLIENTE());
            cst.setInt(7, cliente.getCELULAR());
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

    public String eliminarClientes(Connection con, int idCliente) {
        CallableStatement cst = null;
        String mensaje = "";
        String sql = "{call ELIMINAR_CLIENTE(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, idCliente);
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

  public void listarClientes(Connection con, JTable tabla) {
    CallableStatement cst = null;
    ResultSet rs = null;
    String sql = "{call LISTAR_CLIENTES(?)}";

    try {
        // Preparar la llamada a la función almacenada
        cst = con.prepareCall(sql);
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();

        // Obtener el ResultSet del cursor
        rs = (ResultSet) cst.getObject(1);

        // Crear y configurar el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"CLIENTE", "IDENTIFICACION", "NOMBRE", "1 APELLIDO", "2 APELLIDO", "DIRECCION", "CELULAR"});

        // Llenar el modelo con datos del ResultSet
        while (rs.next()) {
            int id = rs.getInt("ID_CLIENTE");
            int identificacion = rs.getInt("IDENTIFICACION");
            String nombre = rs.getString("NOMBRE_CLIENTE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            String direccion = rs.getString("DIRECCION_CLIENTE");
            int celular = rs.getInt("CELULAR");

            model.addRow(new Object[] {id, identificacion, nombre, primerApellido, segundoApellido, direccion, celular});
        }

        // Asignar el modelo a la tabla
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
