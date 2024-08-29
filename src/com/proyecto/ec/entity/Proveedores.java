/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Proveedores {
    private int ID_PROVEEDOR;
    private String NOMBRE_PROVEEDOR;
    private String DIRECCION_PROVEEDOR;

    public Proveedores() {
    }

    public Proveedores(int ID_PROVEEDOR, String NOMBRE_PROVEEDOR, String DESCRIPCION_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
        this.NOMBRE_PROVEEDOR = NOMBRE_PROVEEDOR;
        this.DIRECCION_PROVEEDOR = DIRECCION_PROVEEDOR;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public String getNOMBRE_PROVEEDOR() {
        return NOMBRE_PROVEEDOR;
    }

    public void setNOMBRE_PROVEEDOR(String NOMBRE_PROVEEDOR) {
        this.NOMBRE_PROVEEDOR = NOMBRE_PROVEEDOR;
    }

    public String getDIRECCION_PROVEEDOR() {
        return DIRECCION_PROVEEDOR;
    }

    public void setDIRECCION_PROVEEDOR(String DIRECCION_PROVEEDOR) {
        this.DIRECCION_PROVEEDOR = DIRECCION_PROVEEDOR;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "ID_PROVEEDOR=" + ID_PROVEEDOR + ", NOMBRE_PROVEEDOR=" + NOMBRE_PROVEEDOR + ", DIRECCION_PROVEEDOR=" + DIRECCION_PROVEEDOR + '}';
    }
    
    
    
}
