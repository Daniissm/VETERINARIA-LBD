package com.especialidad.ec.bo;

import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Producto;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;
import com.proyecto.ec.dao.ProductoDAO;

public class ProductoBO {
    private String mensaje = "";
    private ProductoDAO edao = new ProductoDAO();

    public String agregarProducto(Producto prod) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.agregarProducto(conn, prod);
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

    public String modificarProducto(Producto prod) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.modificarProducto(conn, prod);
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

    public String eliminarProducto(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.eliminarProducto(conn, id);
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

    /**public void listarProducto(JTable tabla) {
        Connection conn = Conexion.getConnection();
        try {
            edao.listarProducto(conn, tabla);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }**/
}
