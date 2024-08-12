/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

/**
 *
 * @author fidelitas
 */
public class Veterinario {
    private int ID_VETERINARIO;
    private String NOMBRE_VETERINARIO;
    private String APELLIDO_PATERNO;
    private int CODIGO_VETERINARIO;
    private int ESPECIALDIAD;

    public Veterinario() {
    }

    public Veterinario(int ID_VETERINARIO, String NOMBRE_VETERINARIO, String APELLIDO_PATERNO, int CODIGO_VETERINARIO, int ESPECIALDIAD) {
        this.ID_VETERINARIO = ID_VETERINARIO;
        this.NOMBRE_VETERINARIO = NOMBRE_VETERINARIO;
        this.APELLIDO_PATERNO = APELLIDO_PATERNO;
        this.CODIGO_VETERINARIO = CODIGO_VETERINARIO;
        this.ESPECIALDIAD = ESPECIALDIAD;
    }

    public int getID_VETERINARIO() {
        return ID_VETERINARIO;
    }

    public void setID_VETERINARIO(int ID_VETERINARIO) {
        this.ID_VETERINARIO = ID_VETERINARIO;
    }

    public String getNOMBRE_VETERINARIO() {
        return NOMBRE_VETERINARIO;
    }

    public void setNOMBRE_VETERINARIO(String NOMBRE_VETERINARIO) {
        this.NOMBRE_VETERINARIO = NOMBRE_VETERINARIO;
    }

    public String getAPELLIDO_PATERNO() {
        return APELLIDO_PATERNO;
    }

    public void setAPELLIDO_PATERNO(String APELLIDO_PATERNO) {
        this.APELLIDO_PATERNO = APELLIDO_PATERNO;
    }

    public int getCODIGO_VETERINARIO() {
        return CODIGO_VETERINARIO;
    }

    public void setCODIGO_VETERINARIO(int CODIGO_VETERINARIO) {
        this.CODIGO_VETERINARIO = CODIGO_VETERINARIO;
    }

    public int getESPECIALDIAD() {
        return ESPECIALDIAD;
    }

    public void setESPECIALDIAD(int ESPECIALDIAD) {
        this.ESPECIALDIAD = ESPECIALDIAD;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "ID_VETERINARIO=" + ID_VETERINARIO + ", NOMBRE_VETERINARIO=" + NOMBRE_VETERINARIO + ", APELLIDO_PATERNO=" + APELLIDO_PATERNO + ", CODIGO_VETERINARIO=" + CODIGO_VETERINARIO + ", ESPECIALDIAD=" + ESPECIALDIAD + '}';
    }
    
}
