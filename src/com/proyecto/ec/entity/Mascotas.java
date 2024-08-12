/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Mascotas {
    private int ID_MASCOTA;
    private String NOMBRE_MASCOTA;
    private String RAZA;
    private int PESO;
    private int ESPECIE;
    private int ID_CLIENTE;

    public Mascotas() {
    }

    public Mascotas(int ID_MASCOTA, String NOMBRE_MASCOTA, String RAZA, int PESO, int ESPECIE, int ID_CLIENTE) {
        this.ID_MASCOTA = ID_MASCOTA;
        this.NOMBRE_MASCOTA = NOMBRE_MASCOTA;
        this.RAZA = RAZA;
        this.PESO = PESO;
        this.ESPECIE = ESPECIE;
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getID_MASCOTA() {
        return ID_MASCOTA;
    }

    public void setID_MASCOTA(int ID_MASCOTA) {
        this.ID_MASCOTA = ID_MASCOTA;
    }

    public String getNOMBRE_MASCOTA() {
        return NOMBRE_MASCOTA;
    }

    public void setNOMBRE_MASCOTA(String NOMBRE_MASCOTA) {
        this.NOMBRE_MASCOTA = NOMBRE_MASCOTA;
    }

    public String getRAZA() {
        return RAZA;
    }

    public void setRAZA(String RAZA) {
        this.RAZA = RAZA;
    }

    public int getPESO() {
        return PESO;
    }

    public void setPESO(int PESO) {
        this.PESO = PESO;
    }

    public int getESPECIE() {
        return ESPECIE;
    }

    public void setESPECIE(int ESPECIE) {
        this.ESPECIE = ESPECIE;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    @Override
    public String toString() {
        return "Mascotas{" + "ID_MASCOTA=" + ID_MASCOTA + ", NOMBRE_MASCOTA=" + NOMBRE_MASCOTA + ", RAZA=" + RAZA + ", PESO=" + PESO + ", ESPECIE=" + ESPECIE + ", ID_CLIENTE=" + ID_CLIENTE + '}';
    }
    
}
