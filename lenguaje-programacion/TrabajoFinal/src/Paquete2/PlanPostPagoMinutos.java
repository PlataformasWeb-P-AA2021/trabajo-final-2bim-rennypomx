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
public class PlanPostPagoMinutos extends PlanCelular{
    protected double minNacional;
    protected double costminNacional;
    protected double minInternacional;
    protected double costminInternacional;
    
    public PlanPostPagoMinutos(Persona p, String cp, String mc, String modc, 
            String nc, double mn, double cn, double mi, double cmi) {
        super(p, cp, mc, modc, nc);
        minNacional=mn;
        costminNacional=cn;
        minInternacional=mi;
        costminInternacional=cmi;
        
    }

    public void setMinNacional(double minNacional) {
        this.minNacional = minNacional;
    }

    public void setCostminNacional(double costminNacional) {
        this.costminNacional = costminNacional;
    }

    public void setMinInternacional(double minInternacional) {
        this.minInternacional = minInternacional;
    }

    public void setCostminInternacional(double costminInternacional) {
        this.costminInternacional = costminInternacional;
    }

    public double getMinNacional() {
        return minNacional;
    }

    public double getCostminNacional() {
        return costminNacional;
    }

    public double getMinInternacional() {
        return minInternacional;
    }

    public double getCostminInternacional() {
        return costminInternacional;
    }

    @Override
    public void setPagomensual() {
        pagomensual=(minNacional*costminNacional)+
                (minInternacional*costminInternacional);
    }
    @Override
    public String toString() {
        String cadena = String.format("\n%s"
            + "\tMinutos Nacionales: %.2f\n"
            + "\tCosto Minutos: %.2f\n"
            + "\tMinutos Internacionales: %.2f\n"
            + "\tCosto: %.2f\n"
            + "\tPago Mensual: %.2f",
            super.toString(),minNacional, costminNacional, minInternacional, 
            costminInternacional,pagomensual);
        return cadena;
    }
}
