/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete1;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Persona implements Serializable{
    protected String nombre;
    protected String apellido;
    protected String Identificacion;
    public Persona (String n, String a, String i){
        nombre = n;
        apellido = a;
        Identificacion = i;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return Identificacion;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("Nombre: %s\nApellido: %s\n"
                + "Identificacion: %s\n", 
                nombre, apellido,Identificacion);
        return cadena;
    }
}
