/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Especialidad {

    private int ID_ESPECIALIDAD;
    private String NOMBRE_ESPECIALIDAD;
    private String DESCRIPCION_ESPECIALIDAD;

    public Especialidad() {
    }

    public Especialidad(int ID_ESPECIALIDAD, String NOMBRE_ESPECIALIDAD, String DESCRIPCION_ESPECIALIDAD) {
        this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
        this.NOMBRE_ESPECIALIDAD = NOMBRE_ESPECIALIDAD;
        this.DESCRIPCION_ESPECIALIDAD = DESCRIPCION_ESPECIALIDAD;
    }

    public int getID_ESPECIALIDAD() {
        return ID_ESPECIALIDAD;
    }

    public void setID_ESPECIALIDAD(int ID_ESPECIALIDAD) {
        this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    }

    public String getNOMBRE_ESPECIALIDAD() {
        return NOMBRE_ESPECIALIDAD;
    }

    public void setNOMBRE_ESPECIALIDAD(String NOMBRE_ESPECIALIDAD) {
        this.NOMBRE_ESPECIALIDAD = NOMBRE_ESPECIALIDAD;
    }

    public String getDESCRIPCION_ESPECIALIDAD() {
        return DESCRIPCION_ESPECIALIDAD;
    }

    public void setDESCRIPCION_ESPECIALIDAD(String DESCRIPCION_ESPECIALIDAD) {
        this.DESCRIPCION_ESPECIALIDAD = DESCRIPCION_ESPECIALIDAD;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "ID_ESPECIALIDAD=" + ID_ESPECIALIDAD + ", NOMBRE_ESPECIALIDAD=" + NOMBRE_ESPECIALIDAD + ", DESCRIPCION_ESPECIALIDAD=" + DESCRIPCION_ESPECIALIDAD + '}';
    }

    
}
