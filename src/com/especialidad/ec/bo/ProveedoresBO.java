/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.especialidad.ec.bo;

import com.proyecto.ec.dao.ProveedoresDAO;
import com.proyecto.ec.dao.ServicioDAO;
import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Proveedores;
import com.proyecto.ec.entity.Servicio;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author fidelitas
 */
public class ProveedoresBO {
    private String mensaje = "";
    private ProveedoresDAO edao = new ProveedoresDAO();

    public String agregarProveedor(Proveedores ser) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.agregarProveedor(conn, ser);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarProveedor(Proveedores ser) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.modificarProveedor(conn, ser);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String eliminarProveedor(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.eliminarProveedor(conn, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public void listarProveedor(JTable tabla) {
        Connection conn = Conexion.getConnection();
        try {
            edao.listarProveedores(conn, tabla);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
   
}
