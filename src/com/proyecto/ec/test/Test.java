/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.test;

import com.especialidad.ec.bo.CitasBO;
import com.especialidad.ec.bo.ClientesBO;
import com.especialidad.ec.bo.EspecialidadBO;
import com.especialidad.ec.bo.EspecieBO;
import com.especialidad.ec.bo.MascotasBO;
import com.proyecto.ec.entity.Citas;
import com.proyecto.ec.entity.Clientes;
import com.proyecto.ec.entity.Especialidad;
import com.proyecto.ec.entity.Especie;
import com.proyecto.ec.entity.Mascotas;
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

    private EspecieBO esp = new EspecieBO();
    private Especie especie = new Especie();
    private String mensaje = "";

    public void insertar() {
        especie.setFAMILIA("Canidae");
        especie.setESPECIE("Lycalopex griseus");
        
        mensaje = esp.agregarEspecie(especie);
        System.out.println(mensaje);
    }

    public void modificar() {
         especie.setID_ESPECIE(1);
        especie.setFAMILIA("Canidae");
        especie.setESPECIE("Lycalopex griseus");
        
        mensaje = esp.agregarEspecie(especie);
        System.out.println(mensaje);
    }

    public void eliminar() {
        mensaje = esp.eliminarEspecie(1); // ID de la cita que quieres eliminar
        System.out.println(mensaje);
    }

    public void listar() {
       // ebo.listarCitas(); // Este método lista las citas en la consola
    }
    *  
    private ClientesBO cli = new ClientesBO();
    private Clientes clientes = new Clientes();
    private String mensaje = "";

    public void insertar() {
        clientes.setIDENTIFICACION(20798);
        clientes.setNOMBRE_CLIENTE("VALERIA");
        clientes.setPRIMER_APELLIDO("RODRIGUEZ");
        clientes.setSEGUNDO_APELLIDO("JIMENEZ");
        clientes.setDIRECCION_CLIENTE("ALAJUELA");
        clientes.setCELULAR(60637265);

        mensaje = cli.agregarClientes(clientes);
        System.out.println(mensaje);
    }//*

    public void modificar() {
        clientes.setID_CLIENTE(7);
        clientes.setIDENTIFICACION(20798);
        clientes.setNOMBRE_CLIENTE("VALERIA");
        clientes.setPRIMER_APELLIDO("RODRIGUEZ");
        clientes.setSEGUNDO_APELLIDO("JIMENEZ");
        clientes.setDIRECCION_CLIENTE("LIMON");
        clientes.setCELULAR(60637265);
        
        mensaje = cli.modificarClientes(clientes);
        System.out.println(mensaje);
    }

    public void eliminar() {
        mensaje = cli.eliminarClientes(1); // ID de la cita que quieres eliminar
        System.out.println(mensaje);
    }
    * **/
    
   /** private MascotasBO mas = new MascotasBO();
    private Mascotas mascotas = new Mascotas();
    private String mensaje = "";

    public void insertar() {
        mascotas.setNOMBRE_MASCOTA("GREY");
        mascotas.setRAZA("GOLDEN RETRIEVER");
        mascotas.setPESO(5);
        mascotas.setESPECIE(5);
        mascotas.setID_CLIENTE(7);

        mensaje = mas.agregarMascotas(mascotas);
        System.out.println(mensaje);
    }**/

    /**public void modificar() {
        clientes.setID_CLIENTE(7);
        clientes.setIDENTIFICACION(20798);
        clientes.setNOMBRE_CLIENTE("VALERIA");
        clientes.setPRIMER_APELLIDO("RODRIGUEZ");
        clientes.setSEGUNDO_APELLIDO("JIMENEZ");
        clientes.setDIRECCION_CLIENTE("LIMON");
        clientes.setCELULAR(60637265);
        
        mensaje = cli.modificarClientes(clientes);
        System.out.println(mensaje);
    }

    public void eliminar() {
        mensaje = cli.eliminarClientes(1); // ID de la cita que quieres eliminar
        System.out.println(mensaje);
    }**/

    EspecialidadBO ebo = new EspecialidadBO();
Especialidad emp = new Especialidad();
String mensaje =  "";

//ClientesBO ebo = new ClientesBO();
//Clientes cli = new Clientes();
//String mensaje =  "";

    public void insertar (){
    emp.setNOMBRE_ESPECIALIDAD("URGENCIOLOGO");
    emp.setDESCRIPCION_ESPECIALIDAD("Especialiad en INTERNAMIENTO");
    mensaje = ebo.agregarEspecialidad(emp);
    System.out.println(mensaje);
    }
    public static void main(String[] args) {
        Test test = new Test();
       test.insertar();
       //test.modificar();
        //test.eliminar();
    }
}

    

