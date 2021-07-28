/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete2;

import Paquete1.Persona;
import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public abstract class PlanCelular implements Serializable{
    protected Persona propietario;
    protected String ciudadPropietario;
    protected String marcacelular;
    protected String modelocelular;
    protected String numerocelular;
    protected double pagomensual;

    public PlanCelular(Persona p, String cp, String mc, String modc, String nc){
        this.propietario = p;
        this.ciudadPropietario = cp;
        this.marcacelular = mc;
        this.modelocelular = modc;
        this.numerocelular = nc;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public void setCiudadPropietario(String CiudadPropietario) {
        this.ciudadPropietario = CiudadPropietario;
    }

    public void setMarcacelular(String marcacelular) {
        this.marcacelular = marcacelular;
    }

    public void setModelocelular(String modelocelular) {
        this.modelocelular = modelocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public abstract void setPagomensual();

    public Persona getPropietario() {
        return propietario;
    }

    public String getCiudadPropietario() {
        return ciudadPropietario;
    }

    public String getMarcacelular() {
        return marcacelular;
    }

    public String getModelocelular() {
        return modelocelular;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public double getPagomensual() {
        return pagomensual;
    } 
    
}
