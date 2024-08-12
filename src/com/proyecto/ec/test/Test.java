/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.test;

import com.especialidad.ec.bo.CitasBO;
import com.especialidad.ec.bo.ClientesBO;
import com.especialidad.ec.bo.EspecialidadBO;
import com.proyecto.ec.entity.Citas;
import com.proyecto.ec.entity.Clientes;
import com.proyecto.ec.entity.Especialidad;
import java.time.LocalDate;

/**
 *
 * @author fidelitas
 */
public class Test 
{
/**EspecialidadBO ebo = new EspecialidadBO();
Especialidad emp = new Especialidad();**/
//ClientesBO ebo = new ClientesBO();
//Clientes cli = new Clientes();
//String mensaje =  "";

/**public void insertar (){
    emp.setNOMBRE_ESPECIALIDAD("ONCOLOGYYYY");
    emp.setDESCRIPCION_ESPECIALIDAD("Especialiad en ultrasonidos");
    mensaje = ebo.agregarEspecialidad(emp);
    System.out.println(mensaje);
    
}
public void modificar (){
    emp.setID_ESPECIALIDAD(1);
    emp.setNOMBRE_ESPECIALIDAD("GINECOLOGY");
    emp.setDESCRIPCION_ESPECIALIDAD("Especialiad en ginecologia");
    mensaje = ebo.modificarEspecialidad(emp);
    System.out.println(mensaje);
    
}
public void eliminar (){
    mensaje = ebo.eliminarEspecialidad(4);
    System.out.println(mensaje);
    
}
    public static void main(String[] args) {
        Test test = new Test();
       //test.insertar();
      //test.modificar();
      test.eliminar();
    }
    public class Test {
    private ClienteBO ebo = new ClienteBO();
    private Cliente cliente = new Cliente();
    private String mensaje = "";

    public void insertar() {
        cli.setIDENTIFICACION(123456);
        cli.setNOMBRE_CLIENTE("");
        cli.setPRIMER_APELLIDO("Pérez");
        cli.setSEGUNDO_APELLIDO("Gómez");
        cli.setDIRECCION_CLIENTE("Calle Falsa 123");
        cli.setCELULAR(987654321);
        mensaje = ebo.agregarClientes(cli);
        System.out.println(mensaje);
    }

    public void modificar() {
        cli.setID_CLIENTE(1); // El ID del cliente que quieres modificar
        cli.setIDENTIFICACION(123456789);
        cli.setNOMBRE_CLIENTE("VALERIA");
        cli.setPRIMER_APELLIDO("RODRIGUEZ");
        cli.setSEGUNDO_APELLIDO("JIMENEZ");
        cli.setDIRECCION_CLIENTE("TAMBOR");
        cli.setCELULAR(987654322);
        mensaje = ebo.modificarClientes(cli);
        System.out.println(mensaje);
    }

    public void eliminar() {
        mensaje = ebo.eliminarClientes(5); // ID del cliente que quieres eliminar
        System.out.println(mensaje);
    }
**/
    private CitasBO ebo = new CitasBO();
    private Citas cita = new Citas();
    private String mensaje = "";

    public void insertar() {
        cita.setFECHA_CITA(LocalDate.of(2024, 8, 12));
        cita.setID_CLIENTE(1);
        cita.setID_VETERINARIO(1);
        cita.setID_MASCOTA(1);
        mensaje = ebo.agregarCita(cita);
        System.out.println(mensaje);
    }

    public void modificar() {
        cita.setID_CITA(1); // El ID de la cita que quieres modificar
        cita.setFECHA_CITA(LocalDate.of(2024, 8, 13));
        cita.setID_CLIENTE(2);
        cita.setID_VETERINARIO(2);
        cita.setID_MASCOTA(2);
        mensaje = ebo.modificarCita(cita);
        System.out.println(mensaje);
    }

    public void eliminar() {
        mensaje = ebo.eliminarCita(1); // ID de la cita que quieres eliminar
        System.out.println(mensaje);
    }

    public void listar() {
       // ebo.listarCitas(); // Este método lista las citas en la consola
    }
    public static void main(String[] args) {
        Test test = new Test();
       test.insertar();
       //test.modificar();
        //test.eliminar();
    }
}

    

