/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ec.test;

import com.especialidad.ec.bo.EspecialidadBO;
import com.proyecto.ec.entity.Especialidad;

/**
 *
 * @author fidelitas
 */
public class Test 
{
EspecialidadBO ebo = new EspecialidadBO();
Especialidad emp = new Especialidad();
String mensaje =  "";
public void insertar (){
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
    
    
}
