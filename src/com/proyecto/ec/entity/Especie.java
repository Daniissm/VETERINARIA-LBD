/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Especie {
   private  int ID_ESPECIE;
   private String FAMILIA;
   private String ESPECIE;

    public Especie() {
    }

    public Especie(int ID_ESPECIE, String FAMILIA, String ESPECIE) {
        this.ID_ESPECIE = ID_ESPECIE;
        this.FAMILIA = FAMILIA;
        this.ESPECIE = ESPECIE;
    }

    public int getID_ESPECIE() {
        return ID_ESPECIE;
    }

    public void setID_ESPECIE(int ID_ESPECIE) {
        this.ID_ESPECIE = ID_ESPECIE;
    }

    public String getFAMILIA() {
        return FAMILIA;
    }

    public void setFAMILIA(String FAMILIA) {
        this.FAMILIA = FAMILIA;
    }

    public String getESPECIE() {
        return ESPECIE;
    }

    public void setESPECIE(String ESPECIE) {
        this.ESPECIE = ESPECIE;
    }

    @Override
    public String toString() {
        return "Especie{" + "ID_ESPECIE=" + ID_ESPECIE + ", FAMILIA=" + FAMILIA + ", ESPECIE=" + ESPECIE + '}';
    }
   
}
