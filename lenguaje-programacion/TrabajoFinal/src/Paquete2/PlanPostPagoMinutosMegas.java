/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete2;

import Paquete1.Persona;

/**
 *
 * @author ASUS
 */
public class PlanPostPagoMinutosMegas extends PlanCelular{
    protected double minutos;
    protected double costminutos;
    protected double mgigas;
    protected double costgigas;
    
    public PlanPostPagoMinutosMegas(Persona p, String cp, String mc,String modc,
            String nc,double m, double cm, double mg,double cg) {
        super(p, cp, mc, modc, nc);
        minutos=m;
        costminutos=cm;
        mgigas=mg;
        costgigas=cg;
    }

    @Override
    public void setPagomensual() {
       pagomensual=(minutos*costminutos)+(mgigas*costgigas);
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public void setCostminutos(double costminutos) {
        this.costminutos = costminutos;
    }

    public void setMgigas(double mgigas) {
        this.mgigas = mgigas;
    }

    public void setCostgigas(double costgigas) {
        this.costgigas = costgigas;
    }

    public double getMinutos() {
        return minutos;
    }

    public double getCostminutos() {
        return costminutos;
    }

    public double getMgigas() {
        return mgigas;
    }

    public double getCostgigas() {
        return costgigas;
    }
    @Override
    public String toString() {
        String cadena = String.format("%s\t"
            + "Minutos: %.2f\n"
            + "\tCosto Minutos: %.2f\n"
            + "\tGigas: %.2f\n\t"
            + "Costo Gigas: %.2f\n"
            + "\tPago Mensual: %.2f", 
            super.toString(), minutos,costminutos, mgigas, 
            costgigas, pagomensual);
        return cadena;
    }
}
