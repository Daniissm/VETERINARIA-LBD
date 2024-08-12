/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class FichaMedica {
    private int ID_FICHA_MEDICA;
    private int ID_MASCOTA;
    private int ID_VETERINARIO;
    private String MOTIVO;
    private String DIAGNOSTICO;
    private String TRATAMIENTO;

    public FichaMedica() {
    }

    public FichaMedica(int ID_FICHA_MEDICA, int ID_MASCOTA, int ID_VETERINARIO, String MOTIVO, String DIAGNOSTICO, String TRATAMIENTO) {
        this.ID_FICHA_MEDICA = ID_FICHA_MEDICA;
        this.ID_MASCOTA = ID_MASCOTA;
        this.ID_VETERINARIO = ID_VETERINARIO;
        this.MOTIVO = MOTIVO;
        this.DIAGNOSTICO = DIAGNOSTICO;
        this.TRATAMIENTO = TRATAMIENTO;
    }

    public int getID_FICHA_MEDICA() {
        return ID_FICHA_MEDICA;
    }

    public void setID_FICHA_MEDICA(int ID_FICHA_MEDICA) {
        this.ID_FICHA_MEDICA = ID_FICHA_MEDICA;
    }

    public int getID_MASCOTA() {
        return ID_MASCOTA;
    }

    public void setID_MASCOTA(int ID_MASCOTA) {
        this.ID_MASCOTA = ID_MASCOTA;
    }

    public int getID_VETERINARIO() {
        return ID_VETERINARIO;
    }

    public void setID_VETERINARIO(int ID_VETERINARIO) {
        this.ID_VETERINARIO = ID_VETERINARIO;
    }

    public String getMOTIVO() {
        return MOTIVO;
    }

    public void setMOTIVO(String MOTIVO) {
        this.MOTIVO = MOTIVO;
    }

    public String getDIAGNOSTICO() {
        return DIAGNOSTICO;
    }

    public void setDIAGNOSTICO(String DIAGNOSTICO) {
        this.DIAGNOSTICO = DIAGNOSTICO;
    }

    public String getTRATAMIENTO() {
        return TRATAMIENTO;
    }

    public void setTRATAMIENTO(String TRATAMIENTO) {
        this.TRATAMIENTO = TRATAMIENTO;
    }

    @Override
    public String toString() {
        return "FichaMedica{" + "ID_FICHA_MEDICA=" + ID_FICHA_MEDICA + ", ID_MASCOTA=" + ID_MASCOTA + ", ID_VETERINARIO=" + ID_VETERINARIO + ", MOTIVO=" + MOTIVO + ", DIAGNOSTICO=" + DIAGNOSTICO + ", TRATAMIENTO=" + TRATAMIENTO + '}';
    }
    
    
}
