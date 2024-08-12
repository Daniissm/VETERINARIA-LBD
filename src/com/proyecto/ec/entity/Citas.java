/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.entity;

import java.time.LocalDate;

/**
 *
 * @author fidelitas
 */
public class Citas {
    private int ID_CITA;
    private LocalDate FECHA_CITA ;
    private int ID_CLIENTE ;
    private int ID_VETERINARIO ;
    private int ID_MASCOTA ;

    public Citas() {
    }

    public Citas(int ID_CITA, LocalDate FECHA_CITA, int ID_CLIENTE, int ID_VETERINARIO, int ID_MASCOTA) {
        this.ID_CITA = ID_CITA;
        this.FECHA_CITA = FECHA_CITA;
        this.ID_CLIENTE = ID_CLIENTE;
        this.ID_VETERINARIO = ID_VETERINARIO;
        this.ID_MASCOTA = ID_MASCOTA;
    }

    public int getID_CITA() {
        return ID_CITA;
    }

    public void setID_CITA(int ID_CITA) {
        this.ID_CITA = ID_CITA;
    }

    public LocalDate getFECHA_CITA() {
        return FECHA_CITA;
    }

    public void setFECHA_CITA(LocalDate FECHA_CITA) {
        this.FECHA_CITA = FECHA_CITA;
    }

    public int getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(int ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }

    public int getID_VETERINARIO() {
        return ID_VETERINARIO;
    }

    public void setID_VETERINARIO(int ID_VETERINARIO) {
        this.ID_VETERINARIO = ID_VETERINARIO;
    }

    public int getID_MASCOTA() {
        return ID_MASCOTA;
    }

    public void setID_MASCOTA(int ID_MASCOTA) {
        this.ID_MASCOTA = ID_MASCOTA;
    }

    @Override
    public String toString() {
        return "Citas{" + "ID_CITA=" + ID_CITA + ", FECHA_CITA=" + FECHA_CITA + ", ID_CLIENTE=" + ID_CLIENTE + ", ID_VETERINARIO=" + ID_VETERINARIO + ", ID_MASCOTA=" + ID_MASCOTA + '}';
    }
    
    
}
