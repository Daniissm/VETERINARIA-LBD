package com.especialidad.ec.bo;

import com.proyecto.ec.db.Conexion;
import com.proyecto.ec.entity.Veterinario;
import java.sql.Connection;
import javax.swing.JTable;
import java.sql.SQLException;
import com.proyecto.ec.dao.VeterinarioDAO;

public class VeterinarioBO {
    private String mensaje = "";
    private VeterinarioDAO edao = new VeterinarioDAO();

    public String agregarVeterinario(Veterinario vet) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.agregarVeterinario(conn, vet);
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

    public String modificarVeterinario(Veterinario vet) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.modificarVeterinario(conn, vet);
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

    public String eliminarVeterinario(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = edao.eliminarVeterinario(conn, id);
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

    public void listarVeterinarios(JTable tabla) {
        Connection conn = Conexion.getConnection();
        try {
            edao.listarVeterinarios(conn, tabla);
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
    public int getMaxID (){
         Connection conn = Conexion.getConnection();
                int id = edao.getMaxID(conn);
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    
                }
                return id;
       }
}

