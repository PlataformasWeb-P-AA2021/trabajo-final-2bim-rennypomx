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
public class PlanPostPagoMinutosMegasEconomico extends PlanCelular{
    protected double minutos;
    protected double costminutos;
    protected double mgigas;
    protected double costgigas;
    protected double descuento;
    
    public PlanPostPagoMinutosMegasEconomico(Persona p, String cp, String mc, 
            String modc, String nc, double m, double cm, double mg, double cg, 
            double d) {
        super(p, cp, mc, modc, nc);
        minutos = m;
        costminutos = cm;
        mgigas = mg;
        costgigas = cg;
        descuento = d;
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

    public void setDescuento() {
        this.descuento = descuento/100;
    }

    @Override
    public void setPagomensual() {
       pagomensual=(minutos*costminutos)+(mgigas*costgigas);
       pagomensual= pagomensual-(pagomensual*descuento);
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

    public double getDescuento() {
        return descuento;
    }
    @Override
    public String toString() {
        String cadena = String.format("%s\n"
            + "\tMinutos: %.2f\n"
            + "\tCosto Minutos: %.2f\n"
            + "\tGigas: %.2f\n"
            + "\tCosto Gigas: %.2f\n"
            + "\tDescuento: %.2f\n"
            + "\tPago Mensual: %.2f", super.toString(), minutos,costminutos, 
            mgigas, costgigas, descuento, pagomensual);
        return cadena;
    }
}
