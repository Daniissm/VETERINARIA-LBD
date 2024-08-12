/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Clientes {
    private int ID_CLIENTE;
    private int IDENTIFICACION;
    private String NOMBRE_CLIENTE;
    private String PRIMER_APELLIDO;
    private String SEGUNDO_APELLIDO;
    private String DIRECCION_CLIENTE;
    private int CELULAR;

    public Clientes() {
    }

    public Clientes(int ID_CLIENTE, int IDENTIFICACION, String NOMBRE_CLIENTE, String PRIMER_APELLIDO, String SEGUNDO_APELLIDO, String DIRECCION_CLIENTE, int CELULAR) {
        this.ID_CLIENTE = ID_CLIENTE;
        this.IDENTIFICACION = IDENTIFICACION;
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
        this.PRIMER_APELLIDO = PRIMER_APELLIDO;
        this.SEGUNDO_APELLIDO = SEGUNDO_APELLIDO;
        this.DIRECCION_CLIENTE = DIRECCION_CLIENTE;
        this.CELULAR = CELULAR;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public void setIDENTIFICACION(int IDENTIFICACION) {
        this.IDENTIFICACION = IDENTIFICACION;
    }

    public String getNOMBRE_CLIENTE() {
        return NOMBRE_CLIENTE;
    }

    public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE) {
        this.NOMBRE_CLIENTE = NOMBRE_CLIENTE;
    }

    public String getPRIMER_APELLIDO() {
        return PRIMER_APELLIDO;
    }

    public void setPRIMER_APELLIDO(String PRIMER_APELLIDO) {
        this.PRIMER_APELLIDO = PRIMER_APELLIDO;
    }

    public String getSEGUNDO_APELLIDO() {
        return SEGUNDO_APELLIDO;
    }

    public void setSEGUNDO_APELLIDO(String SEGUNDO_APELLIDO) {
        this.SEGUNDO_APELLIDO = SEGUNDO_APELLIDO;
    }

    public String getDIRECCION_CLIENTE() {
        return DIRECCION_CLIENTE;
    }

    public void setDIRECCION_CLIENTE(String DIRECCION_CLIENTE) {
        this.DIRECCION_CLIENTE = DIRECCION_CLIENTE;
    }

    public int getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(int CELULAR) {
        this.CELULAR = CELULAR;
    }

    @Override
    public String toString() {
        return "Clientes{" + "ID_CLIENTE=" + ID_CLIENTE + ", IDENTIFICACION=" + IDENTIFICACION + ", NOMBRE_CLIENTE=" + NOMBRE_CLIENTE + ", PRIMER_APELLIDO=" + PRIMER_APELLIDO + ", SEGUNDO_APELLIDO=" + SEGUNDO_APELLIDO + ", DIRECCION_CLIENTE=" + DIRECCION_CLIENTE + ", CELULAR=" + CELULAR + '}';
    }
    
}
