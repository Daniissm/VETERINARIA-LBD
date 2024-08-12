/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Servicio {
   private int ID_SERVICIO;
   private String NOMBRE_SERVICIO;
   private String DESCRIPCION_SERVICIO;
   private int COSTO;

    public Servicio() {
    }

    public Servicio(int ID_SERVICIO, String NOMBRE_SERVICIO, String DESCRIPCION_SERVICIO, int COSTO) {
        this.ID_SERVICIO = ID_SERVICIO;
        this.NOMBRE_SERVICIO = NOMBRE_SERVICIO;
        this.DESCRIPCION_SERVICIO = DESCRIPCION_SERVICIO;
        this.COSTO = COSTO;
    }

    public int getID_SERVICIO() {
        return ID_SERVICIO;
    }

    public void setID_SERVICIO(int ID_SERVICIO) {
        this.ID_SERVICIO = ID_SERVICIO;
    }

    public String getNOMBRE_SERVICIO() {
        return NOMBRE_SERVICIO;
    }

    public void setNOMBRE_SERVICIO(String NOMBRE_SERVICIO) {
        this.NOMBRE_SERVICIO = NOMBRE_SERVICIO;
    }

    public String getDESCRIPCION_SERVICIO() {
        return DESCRIPCION_SERVICIO;
    }

    public void setDESCRIPCION_SERVICIO(String DESCRIPCION_SERVICIO) {
        this.DESCRIPCION_SERVICIO = DESCRIPCION_SERVICIO;
    }

    public int getCOSTO() {
        return COSTO;
    }

    public void setCOSTO(int COSTO) {
        this.COSTO = COSTO;
    }

    @Override
    public String toString() {
        return "Servicio{" + "ID_SERVICIO=" + ID_SERVICIO + ", NOMBRE_SERVICIO=" + NOMBRE_SERVICIO + ", DESCRIPCION_SERVICIO=" + DESCRIPCION_SERVICIO + ", COSTO=" + COSTO + '}';
    }
   
}
