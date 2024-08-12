/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Producto {
    private int ID_PRODUCTO;
    private String NOMBRE_PRODUCTO;
    private String DESCRIPCION_PRODUCTO;
    private int COSTO;
    private int ID_PROVEEDOR;

    public Producto() {
    }

    public Producto(int ID_PRODUCTO, String NOMBRE_PRODUCTO, String DESCRIPCION_PRODUCTO, int COSTO, int ID_PROVEEDOR) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
        this.DESCRIPCION_PRODUCTO = DESCRIPCION_PRODUCTO;
        this.COSTO = COSTO;
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public String getNOMBRE_PRODUCTO() {
        return NOMBRE_PRODUCTO;
    }

    public void setNOMBRE_PRODUCTO(String NOMBRE_PRODUCTO) {
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
    }

    public String getDESCRIPCION_PRODUCTO() {
        return DESCRIPCION_PRODUCTO;
    }

    public void setDESCRIPCION_PRODUCTO(String DESCRIPCION_PRODUCTO) {
        this.DESCRIPCION_PRODUCTO = DESCRIPCION_PRODUCTO;
    }

    public int getCOSTO() {
        return COSTO;
    }

    public void setCOSTO(int COSTO) {
        this.COSTO = COSTO;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    @Override
    public String toString() {
        return "Producto{" + "ID_PRODUCTO=" + ID_PRODUCTO + ", NOMBRE_PRODUCTO=" + NOMBRE_PRODUCTO + ", DESCRIPCION_PRODUCTO=" + DESCRIPCION_PRODUCTO + ", COSTO=" + COSTO + ", ID_PROVEEDOR=" + ID_PROVEEDOR + '}';
    }
    
    
}
