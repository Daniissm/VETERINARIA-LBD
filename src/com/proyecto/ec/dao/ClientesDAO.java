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
        String sql = "{call PACKAGE_CLIENTES.INSERTAR_CLIENTE(?, ?, ?, ?, ?, ?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, cliente.getIDENTIFICACION());
            cst.setString(2, cliente.getNOMBRE_CLIENTE());
            cst.setString(3, cliente.getPRIMER_APELLIDO());
            cst.setString(4, cliente.getSEGUNDO_APELLIDO());
            cst.setString(5, cliente.getDIRECCION_CLIENTE());
            cst.setInt(6, cliente.getCELULAR());
            cst.execute();
            mensaje = "CLIENTE REGISTRADO";
        } catch (SQLException e) {
            mensaje = "ERRRO AL REGISTRAR " + e.getMessage();
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
        String sql = "{call PACKAGE_CLIENTES.ACTUALIZAR_CLIENTE(?, ?, ?, ?, ?, ?, ?)}";
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
            mensaje = "ACTUALIZADO CORRECTAMENTE";
        } catch (SQLException e) {
            mensaje = "ERROR AL ACTUALIZAR" + e.getMessage();
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
        String sql = "{ ? = call PACKAGE_CLIENTES.XELIMINAR_CLIENTE(?) }";

        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.setInt(2, idCliente);
            cst.execute();
            mensaje = cst.getString(1);
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

    public void listarClientes(Connection con, JTable tabla) {
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{? = call PACKAGE_CLIENTES.LISTAR_CLIENTE}";

        try {
            cst = con.prepareCall(sql);
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();
            rs = (ResultSet) cst.getObject(1);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"CLIENTE", "IDENTIFICACION", "NOMBRE", "1 APELLIDO", "2 APELLIDO", "DIRECCION", "CELULAR"});
            while (rs.next()) {
                int id = rs.getInt("ID_CLIENTE");
                int identificacion = rs.getInt("IDENTIFICACION");
                String nombre = rs.getString("NOMBRE_CLIENTE");
                String primerApellido = rs.getString("PRIMER_APELLIDO");
                String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
                String direccion = rs.getString("DIRECCION_CLIENTE");
                int celular = rs.getInt("CELULAR");

                model.addRow(new Object[]{id, identificacion, nombre, primerApellido, segundoApellido, direccion, celular});
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
